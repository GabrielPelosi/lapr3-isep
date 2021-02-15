package lapr.project.model;

import lapr.project.data.AddressDB;

/**
 * The type Address service.
 */
public class AddressService {

    private final AddressDB addressDB;

    /**
     * Instantiates a new Address service.
     */
    public AddressService() {
        this.addressDB = new AddressDB();
    }


    /**
     * Add address boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean addAddress(Address address) {

        boolean x = addressDB.createAddress(address);

        return x;
    }
}
