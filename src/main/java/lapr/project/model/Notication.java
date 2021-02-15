package lapr.project.model;

/**
 * The type Notication.
 */
public class Notication {

    private long id;
    private Costumer costumer;
    private String description;

    /**
     * Instantiates a new Notication.
     *
     * @param id          the id
     * @param costumer    the costumer
     * @param description the description
     */
    public Notication(long id, Costumer costumer, String description) {
        this.id = id;
        this.costumer = costumer;
        this.description = description;
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


}
