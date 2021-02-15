package lapr.project.controller;

import lapr.project.model.ProductService;

/**
 * The type Update stock product controller.
 */
public class UpdateStockProductController {

    private final ProductService productService;

    /**
     * Instantiates a new Update stock product controller.
     */
    public UpdateStockProductController() {
        this.productService = new ProductService();
    }

    /**
     * Update stock product by id boolean.
     *
     * @param id          the id
     * @param pharmacyId  the pharmacy id
     * @param newStockQnt the new stock qnt
     * @return the boolean
     */
    public boolean updateStockProductById(long id, long pharmacyId, long newStockQnt) {
        boolean update;
        if (!productService.validateStockToBeUpdated(id, pharmacyId))
            return false;
        else
            update = productService.updateProductById(id, pharmacyId, newStockQnt);
        return update;
    }
}
