package lapr.project.controller;

import lapr.project.model.CourierService;

/**
 * The type Remove courier controller.
 */
public class RemoveCourierController {

    private final CourierService courierService;

    /**
     * Instantiates a new Remove courier controller.
     */
    public RemoveCourierController() {
        this.courierService = new CourierService();
    }

    /**
     * Remove courier by email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean removeCourierByEmail(String email){
        return courierService.removeCourierByEmail(email);
    }
}
