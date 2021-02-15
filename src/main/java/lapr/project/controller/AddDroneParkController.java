package lapr.project.controller;

import lapr.project.model.ParkService;
import lapr.project.model.Pharmacy;

/**
 * The type Add drone park controller.
 */
public class AddDroneParkController {
    private final ParkService parkService;

    /**
     * Instantiates a new Add drone park controller.
     */
    public AddDroneParkController( ) {
        this.parkService = new ParkService();
    }

    /**
     * Add drone park boolean.
     *
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     * @param pharmacy         the pharmacy
     * @return the boolean
     */
    public boolean addDronePark(int max_charging_cap, int max_parking_cap, Pharmacy pharmacy){
        return parkService.addDronePark(max_charging_cap,max_parking_cap,pharmacy);
    }
}
