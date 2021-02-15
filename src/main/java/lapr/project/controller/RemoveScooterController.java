package lapr.project.controller;

import lapr.project.model.VehicleService;


/**
 * The type Remove scooter controller.
 */
public class RemoveScooterController {

    private final VehicleService vehicleService;

    /**
     * Instantiates a new Remove scooter controller.
     */
    public RemoveScooterController() {
        this.vehicleService = new VehicleService();
    }

    /**
     * Remove scooter by id boolean.
     *
     * @param scooterid the scooterid
     * @return the boolean
     */
    public boolean removeScooterById(long scooterid){
        if (!vehicleService.isVehicleExistsById(scooterid))
            return false;
    return vehicleService.removeScooterById(scooterid);
    }

}