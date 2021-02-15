package lapr.project.model;

import lapr.project.data.PharmacyDB;

import java.util.List;

/**
 * The type Pharmacy service.
 */
public class PharmacyService {

    private final PharmacyDB pharmacyDB;
    private final AddressService addressService;

    /**
     * Instantiates a new Pharmacy service.
     */
    public PharmacyService() {
        this.pharmacyDB = new PharmacyDB();
        this.addressService = new AddressService();
    }

    /**
     * Is product of pharmacy has stock boolean.
     *
     * @param id         the id
     * @param pharmacyId the pharmacy id
     * @param quantity   the quantity
     * @return the boolean
     */
    public boolean isProductOfPharmacyHasStock(long id, long pharmacyId, long quantity) {
        return pharmacyDB.isProductOfPharmacyHasStock(id, pharmacyId, quantity);
    }


    /**
     * Add pharmacy boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean addPharmacy(Address address) {

        if (!addressService.addAddress(address))
            return false;

        return pharmacyDB.addPharmacy(address);
    }

    /**
     * Get all pharmacies with product list.
     *
     * @param pSrc  the p src
     * @param prod  the prod
     * @param stock the stock
     * @return the list
     */
    public List<Pharmacy> getAllPharmaciesWithProduct(Pharmacy pSrc, Product prod, long stock) {


        return pharmacyDB.getAllPharmaciesWithProduct(pSrc, prod, stock);
    }

    public boolean removePharmacyById(long pharmId) {
        return pharmacyDB.removePharmacyById(pharmId);
    }

    public long getLastPharmacyCreated() {
        return pharmacyDB.getLastPharmacyCreated();
    }
}

