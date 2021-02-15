package lapr.project.model;

/**
 * The type Stock.
 */
public class Stock {
    private long id;
    private Pharmacy pharmacy;
    private Product product;
    private int stockQnt;

    /**
     * Instantiates a new Stock.
     *
     * @param id       the id
     * @param pharmacy the pharmacy
     * @param product  the product
     * @param stockQnt the stock qnt
     */
    public Stock(long id, Pharmacy pharmacy, Product product, int stockQnt) {
        this.id = id;
        this.pharmacy = pharmacy;
        this.product = product;
        this.stockQnt = stockQnt;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets pharmacy.
     *
     * @return the pharmacy
     */
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets pharmacy.
     *
     * @param pharmacy the pharmacy
     */
    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stockQnt;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stockQnt = stock;
    }
}
