package lapr.project.model;

/**
 * The type Product.
 */
public class Product {
    private long id;
    private String description;
    private double price;
    private double weight;
    private int quantity;

    /**
     * Instantiates a new Product.
     *
     * @param id          the id
     * @param description the description
     * @param price       the price
     * @param weight      the weight
     * @param quantity    the quantity
     */
    public Product(long id, String description, double price, double weight, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Product(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
