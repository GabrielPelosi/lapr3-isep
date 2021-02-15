package lapr.project.controller;

import lapr.project.model.*;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Create new user order controller.
 */
public class CreateNewUserOrderController {

    private static final double MAX_WEIGH = 10;
    private static final double DELIVERY_TAX = 1.5;
    private static final double CREDIT_DISCOUNT = 0.2;
    private final UserOrderService userOrderService;
    private final PharmacyService pharmacyService;
    private final NotificationService notificationService;
    private final InvoiceService invoiceService;
    private final CostumerService costumerService;
    private final ProductService productService;
    private final CheckProductHasStockController checkStockController;
    private final getNearestPharmacyController nearestPharmController;
    private final CreateBackOrderController backOrderController;


    /**
     * Instantiates a new Create new user order controller.
     */
    public CreateNewUserOrderController( ) {
        this.userOrderService = new UserOrderService();
        this.pharmacyService = new PharmacyService();
        this.notificationService = new NotificationService();
        this.invoiceService= new InvoiceService();
        this.costumerService = new CostumerService();
        this.productService = new ProductService();
        this.checkStockController = new CheckProductHasStockController();
        this.nearestPharmController = new getNearestPharmacyController();
        this.backOrderController = new CreateBackOrderController();

    }

    /**
     * Create new order boolean.
     *
     * @param products       the products
     * @param costumer       the costumer
     * @param deliveryRun    the delivery run
     * @param pharmacy       the pharmacy
     * @param payWithCredits the pay with credits
     * @return the boolean
     */
    public boolean createNewOrder(List<Product> products, Costumer costumer, long deliveryRun, Pharmacy pharmacy, boolean payWithCredits){
        //verify if product has stock, if its not, delete from list and create a notification
        //if there is no product that have stock, stop de order and return false
        double totalWeight = 0;
        for (Product product : products){
            totalWeight += product.getWeight();
        }
        if (totalWeight > MAX_WEIGH){
            System.out.println("Invalid weight.");
            return false;
        }

        List<Product> availableProducts = new ArrayList<>();

        for (Product product : products){
            if(!pharmacyService.isProductOfPharmacyHasStock(product.getId(),pharmacy.getId(),product.getQuantity())){//already tested
                availableProducts.add(product);
            }else {
                System.out.println("Creating back-order");
                Pharmacy nearest = nearestPharmController.getNearestPharmacyWithProduct(pharmacy,product,product.getQuantity());
                if (nearest == null){
                    System.out.println("Unable to create a back Order, the product is out of stock");
                }else{
                backOrderController.createBackOrder(pharmacy,nearest,product,product.getQuantity());
                notificationService.createNotificationOfInvalidProduct(costumer,"The product "+ product.getDescription() +  " was out of stock,and back-order as been created");
                    availableProducts.add(product);
            }}
        }



        //create new user order, if pharmacy invalid, error and false
        //get id of last created userorder
        if(!userOrderService.createNewUserOrder(costumer,pharmacy,totalWeight))//tested
            return false;

        long userorderId = userOrderService.getLastUserOrderCreated();//tested

        //add products in order created
        double total = 0;
        for(Product product : availableProducts){
            userOrderService.addProductsToCreatedOrder(userorderId,product.getId(),product.getQuantity());//tested
            productService.updateStockAfterOrder(pharmacy.getId(),product.getId(),product.getQuantity());//tested
            total += (product.getPrice() * product.getQuantity());
        }



        if (payWithCredits){
            if(costumerService.hasEnoughCreditsById(costumer.getId())){
                costumerService.payDeliveryTaxWithCredits(costumer.getId());
            }else{
                System.out.println("You don't have enough credits to pay delivery tax");
                total = total + DELIVERY_TAX;
                costumerService.updateCredtisOfCostumerById(costumer.getId(),(total * CREDIT_DISCOUNT));
            }
        }else{
            total = total + DELIVERY_TAX;
            costumerService.updateCredtisOfCostumerById(costumer.getId(),(total * CREDIT_DISCOUNT));
        }

        //create the invoice
        System.out.println("Creating issue");
        invoiceService.createNewInvoice(userorderId,total);//already tested

        return true;
    }
}
