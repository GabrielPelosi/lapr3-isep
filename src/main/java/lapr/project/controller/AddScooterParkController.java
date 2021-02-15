package lapr.project.controller;

import lapr.project.model.ParkService;
import lapr.project.model.Pharmacy;

/**
 * The type Add scooter park controller.
 */
public class AddScooterParkController {

    private final ParkService parkService;

    /**
     * Instantiates a new Add scooter park controller.
     */
    public AddScooterParkController() {
        this.parkService = new ParkService();
    }

    /**
     * Add scooter park to pharmacy boolean.
     *
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     * @param pharmacy         the pharmacy
     * @return the boolean
     */
    public boolean addScooterParkToPharmacy(int max_charging_cap, int max_parking_cap, Pharmacy pharmacy){
        return parkService.addScooterPark( max_charging_cap,  max_parking_cap, pharmacy);
    }
}
