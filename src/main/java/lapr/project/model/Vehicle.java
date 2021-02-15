package lapr.project.model;

/**
 * The type Vehicle.
 */
public class Vehicle {
    private long id;
    private Pharmacy pharmacy;
    private float batCapacity;
    private double max_battery;
    private double actual_battery;
    private double aerodinamic;
    private double frontarea;
    private double weight;

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
     * Gets bat capacity.
     *
     * @return the bat capacity
     */
    public float getBatCapacity() {
        return batCapacity;
    }

    /**
     * Sets bat capacity.
     *
     * @param batCapacity the bat capacity
     */
    public void setBatCapacity(float batCapacity) {
        this.batCapacity = batCapacity;
    }

    /**
     * Gets max battery.
     *
     * @return the max battery
     */
    public double getMax_battery() {
        return max_battery;
    }

    /**
     * Sets max battery.
     *
     * @param max_battery the max battery
     */
    public void setMax_battery(double max_battery) {
        this.max_battery = max_battery;
    }

    /**
     * Gets actual battery.
     *
     * @return the actual battery
     */
    public double getActual_battery() {
        return actual_battery;
    }

    /**
     * Sets actual battery.
     *
     * @param actual_battery the actual battery
     */
    public void setActual_battery(double actual_battery) {
        this.actual_battery = actual_battery;
    }

    /**
     * Gets aerodinamic.
     *
     * @return the aerodinamic
     */
    public double getAerodinamic() {
        return aerodinamic;
    }

    /**
     * Sets aerodinamic.
     *
     * @param aerodinamic the aerodinamic
     */
    public void setAerodinamic(double aerodinamic) {
        this.aerodinamic = aerodinamic;
    }

    /**
     * Gets frontarea.
     *
     * @return the frontarea
     */
    public double getFrontarea() {
        return frontarea;
    }

    /**
     * Sets frontarea.
     *
     * @param frontarea the frontarea
     */
    public void setFrontarea(double frontarea) {
        this.frontarea = frontarea;
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
     * Instantiates a new Vehicle.
     *
     * @param id          the id
     * @param pharmacy    the pharmacy
     * @param batCapacity the bat capacity
     */
    public Vehicle(long id, Pharmacy pharmacy, float batCapacity) {
        this.id = id;
        this.pharmacy = pharmacy;
        this.batCapacity = batCapacity;
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param id             the id
     * @param pharmacy       the pharmacy
     * @param batCapacity    the bat capacity
     * @param max_battery    the max battery
     * @param actual_battery the actual battery
     * @param aerodinamic    the aerodinamic
     * @param frontarea      the frontarea
     * @param weight         the weight
     */
    public Vehicle(long id, Pharmacy pharmacy, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight) {
        this.id = id;
        this.pharmacy = pharmacy;
        this.batCapacity = batCapacity;
        this.max_battery = max_battery;
        this.actual_battery = actual_battery;
        this.aerodinamic = aerodinamic;
        this.frontarea = frontarea;
        this.weight = weight;
    }

    public Vehicle(long id) {
        this.id = id;
    }
}

