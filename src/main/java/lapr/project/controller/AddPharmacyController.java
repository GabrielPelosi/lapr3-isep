package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.PharmacyService;

/**
 * The type Add pharmacy controller.
 */
public class AddPharmacyController {
    private final PharmacyService pharmacyService;

    /**
     * Instantiates a new Add pharmacy controller.
     */
    public AddPharmacyController() {
        this.pharmacyService = new PharmacyService();
    }

    /**
     * Add pharmacy boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean addPharmacy(Address address){
        return pharmacyService.addPharmacy(address);
    }
}
