package lapr.project.controller;

import lapr.project.model.ProductService;


/**
 * The type Check product has stock controller.
 */
public class CheckProductHasStockController {

    private final ProductService pServ;

    /**
     * Instantiates a new Check product has stock controller.
     */
    public CheckProductHasStockController() {
        pServ = new ProductService();
    }


    /**
     * Gets product in pharmacy.
     *
     * @param pharmID the pharm id
     * @param idProd  the id prod
     * @return the product in pharmacy
     */
    public long getProductInPharmacy(long pharmID,long idProd) {

        return pServ.getProductStock(pharmID,idProd);
    }


}
