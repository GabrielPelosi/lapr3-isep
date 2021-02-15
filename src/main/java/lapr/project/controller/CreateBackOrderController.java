package lapr.project.controller;

import lapr.project.model.BackOrder;
import lapr.project.model.BackOrderService;
import lapr.project.model.Pharmacy;
import lapr.project.model.Product;

/**
 * The type Create back order controller.
 */
public class CreateBackOrderController {

    private final BackOrderService serv;


    /**
     * Instantiates a new Create back order controller.
     */
    public CreateBackOrderController(){
        serv = new BackOrderService();


    }

    /**
     * Create back order boolean.
     *
     * @param askPharm the ask pharm
     * @param srcPharm the src pharm
     * @param prod     the prod
     * @param stock    the stock
     * @return the boolean
     */
    public boolean createBackOrder(Pharmacy askPharm, Pharmacy srcPharm, Product prod, long stock){

    BackOrder bOrder = new BackOrder(1, askPharm, srcPharm, prod, stock);

        return serv.addBackOrder(bOrder);
}

}
