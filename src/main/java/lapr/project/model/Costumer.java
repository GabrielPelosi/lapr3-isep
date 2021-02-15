package lapr.project.model;

import lapr.project.data.AddressDB;
import lapr.project.data.CostumerDB;

import java.util.Objects;

/**
 * The type Costumer.
 */
public class Costumer {
    private long id;
    private PHUser user;
    private long nif;
    private long cred;
    private Address address;

    /**
     * Instantiates a new Costumer.
     *
     * @param id   the id
     * @param user the user
     * @param cred the cred
     * @param nif  the nif
     */
    public Costumer(long id, PHUser user, long cred, long nif) {

        this.id = id;
        this.user = user;
        this.nif = nif;
        this.cred = cred;

    }

    /**
     * Instantiates a new Costumer.
     *
     * @param id   the id
     * @param user the user
     * @param nif  the nif
     */
    public Costumer(long id, PHUser user, long nif) {
        this.id = id;
        this.user = user;
        this.nif = nif;
        this.cred = 0;
    }

    /**
     * Instantiates a new Costumer.
     *
     * @param id      the id
     * @param user    the user
     * @param nif     the nif
     * @param address the address
     */
    public Costumer(long id, PHUser user, long nif, Address address) {
        this.id = id;
        this.user = user;
        this.nif = nif;
        this.cred = 0;
        this.address = address;
    }

    public Costumer(Costumer c){
        this.id = c.getId();
        this.user = c.getIdUser();
        this.nif = c.getNif();
        this.cred = c.getCred();
        this.address = c.getAddress();
    }

    public Costumer(Address address) {
        this.address = new Address(address);
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets id user.
     *
     * @return the id user
     */
    public PHUser getIdUser() {
        return user;
    }

    /**
     * Gets nif.
     *
     * @return the nif
     */
    public long getNif() {
        return nif;
    }

    /**
     * Gets cred.
     *
     * @return the cred
     */
    public long getCred() {
        return cred;
    }

    /**
     * Sets nif.
     *
     * @param nif the nif
     */
    public void setNif(long nif) {
        this.nif = nif;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}