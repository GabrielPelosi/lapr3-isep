package lapr.project.controller;

import lapr.project.model.Vehicle;
import lapr.project.model.VehicleService;


/**
 * The type Remove dronecontroller.
 */
public class RemoveDronecontroller {
    private final VehicleService vehicleService;

    /**
     * Instantiates a new Remove dronecontroller.
     */
    public RemoveDronecontroller() {
        this.vehicleService = new VehicleService();
    }

    /**
     * Remove drone by id boolean.
     *
     * @param droneId the drone id
     * @return the boolean
     */
    public boolean removeDroneById(long droneId){
        if (!vehicleService.isVehicleExistsById(droneId))
            return false;

        return vehicleService.removeDroneByid(droneId);

    }
}
