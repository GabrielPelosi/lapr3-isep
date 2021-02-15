

package lapr.project.model;

import lapr.project.data.Delivery_RunDB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Delivery run service.
 */
public class DeliveryRunService {

    private final Delivery_RunDB delivery_runDB;
    /**
     * The Logger.
     */
    Logger logger
            = Logger.getLogger(
            DeliveryRunService.class.getName());

    /**
     * Instantiates a new Delivery run service.
     */
    public DeliveryRunService() {
        this.delivery_runDB = new Delivery_RunDB();
    }

    /**
     * Add delivery boolean.
     *
     * @param vehicleId     the vehicle id
     * @param userOrderList the user order list
     * @param pharmacy      the pharmacy
     * @return the boolean
     */
    public boolean addDelivery(Vehicle vehicleId, List<UserOrder> userOrderList, Pharmacy pharmacy) {
        double total = 0;
        for (UserOrder u : userOrderList) {
            total = total + u.getTotalWieght();
        }
        if (total > 20) {
            return false;
        }
        List<UserOrder> userAvailabe = new ArrayList<>();
        for (UserOrder u : userOrderList) {
            if (delivery_runDB.checkIdDelivery(u)) {
                userAvailabe.add(u);
            }
        }

        if (userAvailabe.isEmpty()) {
            logger.log(Level.WARNING, "There is no userorder where delivery has not been declared");
            return false;
        }
        if (!delivery_runDB.vehicleFree(vehicleId)) {
            logger.log(Level.WARNING, "The vehicle cannot be used");
            return false;
        } else {
            return delivery_runDB.createDelivery(new Delivery(vehicleId, total, userAvailabe, pharmacy));

        }
    }


    /**
     * Update state boolean.
     *
     * @param vehicleId the vehicle id
     * @param state     the state
     * @return the boolean
     */
    public boolean updateState(long vehicleId, long state) {
        return delivery_runDB.update_State(vehicleId, state);
    }

    /**
     * Remove deliveries run of specific scooter boolean.
     *
     * @param scooterid the scooterid
     * @return the boolean
     */
    public boolean removeDeliveriesRunOfSpecificScooter(long scooterid) {
        return delivery_runDB.removeDeliveriesRunOfSpecificScooter(scooterid);
    }

    /**
     * Remove deliveries run of specific drone boolean.
     *
     * @param droneId the drone id
     * @return the boolean
     */
    public boolean removeDeliveriesRunOfSpecificDrone(long droneId) {
        return delivery_runDB.removeDeliveriesRunOfSpecificDrone(droneId);
    }

    /**
     * Id delivery exist boolean.
     *
     * @param idDelivery the id delivery
     * @return the boolean
     */
    public boolean idDeliveryExist(long idDelivery) {
        return delivery_runDB.idDeliveryExist(idDelivery);
    }
}
