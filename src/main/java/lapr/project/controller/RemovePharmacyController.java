package lapr.project.controller;

import lapr.project.model.PharmacyService;

/**
 * The type Remove pharmacy controller.
 */
public class RemovePharmacyController {
    private final PharmacyService pharmacyService;

    /**
     * Instantiates a new Remove pharmacy controller.
     */
    public RemovePharmacyController() {
        this.pharmacyService = new PharmacyService();
    }


    /**
     * Remove pharmacy by id boolean.
     *
     * @param pharmId the pharm id
     * @return the boolean
     */
    public boolean RemovePharmacyById(long pharmId){
        return pharmacyService.removePharmacyById(pharmId);
    }
}

