package lapr.project.controller;

import lapr.project.model.ParkService;

/**
 * The type Remove scooter park controller.
 */
public class RemoveScooterParkController {

    private final ParkService parkService;

    /**
     * Instantiates a new Remove scooter park controller.
     */
    public RemoveScooterParkController() {
        this.parkService = new ParkService();
    }

    /**
     * Remove scooter park by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean removeScooterParkById(long id){
        return parkService.removeParkById(id);
    }
}
