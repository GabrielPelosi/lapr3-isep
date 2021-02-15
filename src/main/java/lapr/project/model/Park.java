package lapr.project.model;

/**
 * The type Park.
 */
public class Park {

    private long id;

    private int max_charging_cap;
    private int max_parking_cap;
    private String parkTypeDescription;
    private Pharmacy pharmacy;

    /**
     * Instantiates a new Park.
     *
     * @param id               the id
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     */
    public Park(long id, int max_charging_cap, int max_parking_cap) {
        this.id = id;
        this.max_charging_cap = max_charging_cap;
        this.max_parking_cap = max_parking_cap;
    }

    /**
     * Instantiates a new Park.
     *
     * @param id               the id
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     * @param pharmacy         the pharmacy
     */
    public Park(long id, int max_charging_cap, int max_parking_cap,  Pharmacy pharmacy) {
        this.id = id;
        this.max_charging_cap = max_charging_cap;
        this.max_parking_cap = max_parking_cap;
        this.pharmacy = pharmacy;
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
     * Gets chargins slot.
     *
     * @return the chargins slot
     */
    public int getnCharginsSlot() {
        return max_charging_cap;
    }

    /**
     * Sets chargins slot.
     *
     * @param nCharginsSlot the n chargins slot
     */
    public void setnCharginsSlot(int nCharginsSlot) {
        this.max_charging_cap = nCharginsSlot;
    }

    /**
     * Gets parkings slot.
     *
     * @return the parkings slot
     */
    public int getnParkingsSlot() {
        return max_parking_cap;
    }

    /**
     * Sets parkings slot.
     *
     * @param nParkingsSlot the n parkings slot
     */
    public void setnParkingsSlot(int nParkingsSlot) {
        this.max_parking_cap = nParkingsSlot;
    }
}
