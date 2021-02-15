package lapr.project.model;

import lapr.project.data.ProductDB;

import java.util.List;

/**
 * The type Product service.
 */
public class ProductService {

    private final ProductDB productDB;

    /**
     * Instantiates a new Product service.
     */
    public ProductService() {
        this.productDB = new ProductDB();
    }

    /**
     * Update product by id boolean.
     *
     * @param id          the id
     * @param pharmacyId  the pharmacy id
     * @param newStockQnt the new stock qnt
     * @return the boolean
     */
    public boolean updateProductById(long id, long pharmacyId, long newStockQnt){
        if (!productDB.isExistsProductInPharmacy(id, pharmacyId)){
            return false;
        }else {
            return productDB.updateProductById(id, pharmacyId, newStockQnt);
        }
    }

    /**
     * Validate stock to be updated boolean.
     *
     * @param id         the id
     * @param pharmacyId the pharmacy id
     * @return the boolean
     */
    public boolean validateStockToBeUpdated(long id, long pharmacyId) {
        return productDB.isExistsProductInPharmacy(id, pharmacyId);

    }

    /**
     * Update stock after order boolean.
     *
     * @param prodId     the prod id
     * @param pharmacyId the pharmacy id
     * @param quantity   the quantity
     * @return the boolean
     */
    public boolean updateStockAfterOrder(long prodId, long pharmacyId, long quantity) {
        return productDB.updateProductAfterOrder(prodId,pharmacyId,quantity);
    }


    /**
     * Gets product stock.
     *
     * @param idProd  the id prod
     * @param pharmID the pharm id
     * @return the product stock
     */
    public long getProductStock(long idProd, long pharmID) {
        if (!productDB.isExistsProductInPharmacy(idProd, pharmID)){
            return -1;
        }else {
            return productDB.getProductStock(idProd, pharmID);
        }
    }

    /**
     * Gets peso produto.
     *
     * @param idProd the id prod
     * @return the peso produto
     */
    public double getPesoProduto(long idProd) {

        return productDB.getPesoProduto(idProd);
    }
}
