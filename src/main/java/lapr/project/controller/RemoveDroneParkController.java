package lapr.project.controller;

import lapr.project.model.ParkService;

/**
 * The type Remove drone park controller.
 */
public class RemoveDroneParkController {
    private final ParkService parkService;

    /**
     * Instantiates a new Remove drone park controller.
     */
    public RemoveDroneParkController() {
        this.parkService = new ParkService();
    }

    /**
     * Remove drone park by id boolean.
     *
     * @param idPark the id park
     * @return the boolean
     */
    public boolean removeDroneParkById(long idPark){
        if (!parkService.isParkExistsById(idPark))
            return false;
        return parkService.removeParkById(idPark);
    }
}
