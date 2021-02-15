package lapr.project.model;

/**
 * The type Back order.
 */
public class BackOrder {


    private long id;
    private Pharmacy askPharm;
    private Pharmacy srcPharm;
    private Product prod;
    private long stock;

    /**
     * Instantiates a new Back order.
     *
     * @param id       the id
     * @param askPharm the ask pharm
     * @param srcPharm the src pharm
     * @param prod     the prod
     * @param stock    the stock
     */
    public BackOrder(long id, Pharmacy askPharm, Pharmacy srcPharm, Product prod, long stock ){

        this.id = id;
        this.askPharm = askPharm;
        this.srcPharm = srcPharm;
        this.prod = prod;
        this.stock = stock;


    }


    /**
     * Gets ask pharmacy.
     *
     * @return the ask pharmacy
     */
    public Pharmacy getAskPharmacy() {

        return this.askPharm;
    }

    /**
     * Gets src pharmacy.
     *
     * @return the src pharmacy
     */
    public Pharmacy getSrcPharmacy() {

       return this.srcPharm;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return this.prod;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public long getStock() {

        return  this.stock;
    }
}
