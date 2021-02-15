package lapr.project.model;

/**
 * The type Courier.
 */
public class Courier {
    private long id;
    private PHUser phUser;
    private Pharmacy pharmacy;

    /**
     * Instantiates a new Courier.
     *
     * @param id       the id
     * @param phUser   the ph user
     * @param pharmacy the pharmacy
     */
    public Courier(long id, PHUser phUser, Pharmacy pharmacy) {
        this.id = id;
        this.phUser = phUser;
        this.pharmacy = pharmacy;
    }

    public Courier(long id, Pharmacy pharmacy) {
        this.id = id;
        this.pharmacy = new Pharmacy(pharmacy);
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
     * Gets ph user.
     *
     * @return the ph user
     */
    public PHUser getPhUser() {
        return phUser;
    }

    /**
     * Sets ph user.
     *
     * @param phUser the ph user
     */
    public void setPhUser(PHUser phUser) {
        this.phUser = phUser;
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


}
