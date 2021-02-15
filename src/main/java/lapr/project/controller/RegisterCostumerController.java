package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.CostumerService;
import lapr.project.model.PHUserService;
import lapr.project.model.Pharmacy;

/**
 * The type Register costumer controller.
 */
public class RegisterCostumerController {


    private final CostumerService costumerService;

    /**
     * Instantiates a new Register costumer controller.
     */
    public RegisterCostumerController() {
        this.costumerService = new CostumerService();
    }

    /**
     * Register costumer boolean.
     *
     * @param userName the user name
     * @param email    the email
     * @param password the password
     * @param address  the address
     * @param nif      the nif
     * @return the boolean
     */
    public boolean registerCostumer(String userName, String email, String password, Address address, int nif){
        return costumerService.registerCostumer(userName,email,password,address, nif);
    }
}
