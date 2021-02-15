package lapr.project.controller;



import lapr.project.model.VehicleService;

/**
 * The type Add scooter controller.
 */
public class AddScooterController {

    private final VehicleService vehicleService;

    /**
     * Instantiates a new Add scooter controller.
     */
    public AddScooterController() {
        this.vehicleService = new VehicleService();
    }


    /**
     * Add scooter boolean.
     *
     * @param pharmacyId     the pharmacy id
     * @param batCapacity    the bat capacity
     * @param max_battery    the max battery
     * @param actual_battery the actual battery
     * @param aerodinamic    the aerodinamic
     * @param frontarea      the frontarea
     * @param weight         the weight
     * @return the boolean
     */
    public boolean addScooter( long pharmacyId, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight ){
        return vehicleService.addScooter( pharmacyId,  batCapacity,  max_battery,  actual_battery,  aerodinamic,  frontarea,  weight );
    }
}
