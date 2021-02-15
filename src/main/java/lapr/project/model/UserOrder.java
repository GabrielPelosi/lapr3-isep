package lapr.project.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The type User order.
 */
public class UserOrder {
    private long id;
    private Costumer costumer;
    private Pharmacy pharmacy;
    private List<Product> products;
    private long deliveryRunId;
    private double totalWieght;


    /**
     * Instantiates a new User order.
     *
     * @param id            the id
     * @param costumer      the costumer
     * @param products      the products
     * @param deliveryRunId the delivery run id
     */
    public UserOrder(long id, Costumer costumer, List<Product> products, long deliveryRunId) {
        this.id = id;
        this.costumer = costumer;
        this.products = new LinkedList<>(products);
        this.deliveryRunId = deliveryRunId;
    }

    /**
     * Instantiates a new User order.
     *
     * @param id            the id
     * @param costumer      the costumer
     * @param pharmacy      the pharmacy
     * @param products      the products
     * @param deliveryRunId the delivery run id
     */
    public UserOrder(long id, Costumer costumer, Pharmacy pharmacy, List<Product> products, long deliveryRunId) {
        this.id = id;
        this.costumer = costumer;
        this.pharmacy = pharmacy;
        this.products = new LinkedList<>(products);
        this.deliveryRunId = deliveryRunId;
    }

    /**
     * Instantiates a new User order.
     *
     * @param id            the id
     * @param costumer      the costumer
     * @param pharmacy      the pharmacy
     * @param products      the products
     * @param deliveryRunId the delivery run id
     * @param totalWieght   the total wieght
     */
    public UserOrder(long id, Costumer costumer, Pharmacy pharmacy, List<Product> products, long deliveryRunId, double totalWieght) {
        this.id = id;
        this.costumer = costumer;
        this.pharmacy = pharmacy;
        this.products = products;
        this.deliveryRunId = deliveryRunId;
        this.totalWieght = totalWieght;
    }

    public UserOrder(Costumer costumer) {
        this.costumer = new Costumer(costumer);
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
     * Gets costumer.
     *
     * @return the costumer
     */
    public Costumer getCostumer() {
        return costumer;
    }

    /**
     * Sets costumer.
     *
     * @param costumer the costumer
     */
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Product> getProducts() {
        return new LinkedList<>(products);
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = new LinkedList<>(products);
    }

    /**
     * Gets delivery run id.
     *
     * @return the delivery run id
     */
    public long getDeliveryRunId() {
        return deliveryRunId;
    }

    /**
     * Sets delivery run id.
     *
     * @param deliveryRunId the delivery run id
     */
    public void setDeliveryRunId(long deliveryRunId) {
        this.deliveryRunId = deliveryRunId;
    }

    /**
     * Gets total wieght.
     *
     * @return the total wieght
     */
    public double getTotalWieght() {
        return totalWieght;
    }

    /**
     * Sets total wieght.
     *
     * @param totalWieght the total wieght
     */
    public void setTotalWieght(double totalWieght) {
        this.totalWieght = totalWieght;
    }
}
