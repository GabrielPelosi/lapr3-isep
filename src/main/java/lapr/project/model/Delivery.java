package lapr.project.model;



import java.util.LinkedList;
import java.util.List;

/**
 * The type Delivery.
 */
public class Delivery {

    private long idDelivery;
    private Vehicle idvehicle;
    private double weight;
    private final List<UserOrder> userOrderList;
    private Pharmacy pharmacy;

    public Delivery(long idDelivery, Vehicle idvehicle, long weight, List<UserOrder> userOrderList, Pharmacy pharmacy) {
        this.idDelivery = idDelivery;
        this.idvehicle = idvehicle;
        this.weight = weight;
        this.userOrderList = userOrderList;
        this.pharmacy = pharmacy;
    }

    /**
     * Instantiates a new Delivery.
     *
     * @param idvehicle     the idvehicle
     * @param weight        the weight
     * @param userOrderList the user order list
     * @param pharmacy      the pharmacy
     */
    public Delivery(Vehicle idvehicle, double weight, List<UserOrder> userOrderList, Pharmacy pharmacy) {
        this.idvehicle = idvehicle;
        this.weight = weight;
        this.userOrderList = userOrderList;
        this.pharmacy = pharmacy;
    }

    /**
     * Instantiates a new Delivery.
     *
     * @param idvehicle     the idvehicle
     * @param weight        the weight
     * @param userOrderList the user order list
     */
    public Delivery(Vehicle idvehicle, long weight, List<UserOrder> userOrderList) {
        this.idvehicle = idvehicle;
        this.weight = weight;
        this.userOrderList = userOrderList;
    }

    /**
     * Instantiates a new Delivery.
     *
     * @param del the del
     */
    public Delivery(Delivery del) {
        this.idvehicle = del.getIdvehicle();
        this.weight = del.getWeight();
        this.userOrderList = del.getUserOrderList();
        this.pharmacy = del.getPharmacy();
    }


    /**
     * Gets idvehicle.
     *
     * @return the idvehicle
     */
    public Vehicle getIdvehicle() {
        return idvehicle;
    }

    /**
     * Sets idvehicle.
     *
     * @param idvehicle the idvehicle
     */
    public void setIdvehicle(Vehicle idvehicle) {
        this.idvehicle = idvehicle;
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
     * Gets user order list.
     *
     * @return the user order list
     */
    public List<UserOrder> getUserOrderList() {
               return userOrderList;
    }

    public long getIdDelivery() {
        return idDelivery;
    }
}

