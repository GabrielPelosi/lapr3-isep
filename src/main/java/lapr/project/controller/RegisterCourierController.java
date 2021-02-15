package lapr.project.controller;

import lapr.project.model.*;

/**
 * The type Register courier controller.
 */
public class RegisterCourierController {

    private final CourierService courierService;
    private final  PHUserService phUserService;

    /**
     * Instantiates a new Register courier controller.
     */
    public RegisterCourierController() {
        this.courierService = new CourierService();
        this.phUserService= new PHUserService();
    }

    /**
     * Create new courier boolean.
     *
     * @param userName the user name
     * @param email    the email
     * @param password the password
     * @param pharmacy the pharmacy
     * @return the boolean
     */
    public boolean createNewCourier(String userName, String email, String password, Pharmacy pharmacy){
        return courierService.createNewCourier(userName,email,password,pharmacy);
    }

    /**
     * Remove courier by id boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean removeCourierById(String email) {
        return courierService.removeCourierByEmail(email);
    }
}
