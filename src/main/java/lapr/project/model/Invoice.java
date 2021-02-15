package lapr.project.model;

/**
 * The type Invoice.
 */
public class Invoice {
    private long id;
    private UserOrder userOrder;
    private double total;


    /**
     * Instantiates a new Invoice.
     *
     * @param id        the id
     * @param userOrder the user order
     * @param total     the total
     */
    public Invoice(long id, UserOrder userOrder, double total) {
        this.id = id;
        this.userOrder = userOrder;
        this.total = total;
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
     * Gets user order.
     *
     * @return the user order
     */
    public UserOrder getUserOrder() {
        return userOrder;
    }

    /**
     * Sets user order.
     *
     * @param userOrder the user order
     */
    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
