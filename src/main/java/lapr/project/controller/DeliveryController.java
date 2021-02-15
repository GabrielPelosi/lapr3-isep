package lapr.project.controller;

import lapr.project.model.DeliveryRunService;
import lapr.project.model.Pharmacy;
import lapr.project.model.UserOrder;
import lapr.project.model.Vehicle;

import java.util.List;

/**
 * The type Delivery controller.
 */
public class DeliveryController {
    private final DeliveryRunService deliveryRunService;

    /**
     * Instantiates a new Delivery controller.
     */
    public DeliveryController() {
        this.deliveryRunService = new DeliveryRunService();
    }

    /**
     * Add delivery boolean.
     *
     * @param vehicleID     the vehicle id
     * @param userOrderList the user order list
     * @param pharmacy      the pharmacy
     * @return the boolean
     */
    public boolean addDelivery(Vehicle vehicleID, List<UserOrder> userOrderList, Pharmacy pharmacy) {
        return deliveryRunService.addDelivery(vehicleID, userOrderList,pharmacy);
    }

    /**
     * Update state boolean.
     *
     * @param deliveryID the delivery id
     * @param state      the state
     * @return the boolean
     */
    public boolean updateState(long deliveryID, long state) {
     if (!deliveryRunService.idDeliveryExist(deliveryID))
         return false;
        return deliveryRunService.updateState(deliveryID, state);
    }

}
