package lapr.project.model;

import java.util.Objects;

/**
 * The type Pharmacy.
 */
public class Pharmacy {

    private long id;
    private Address address;


    /**
     * Instantiates a new Pharmacy.
     *
     * @param id      the id
     * @param address the address
     */
    public Pharmacy(long id, Address address) {
        this.id = id;
        this.address = address;
    }


    public Pharmacy(long id){
        this.id = id;
    }


    /**
     * Instantiates a new Pharmacy.
     *
     * @param pharmacy the pharmacy
     */
    public Pharmacy(Pharmacy pharmacy) {
        this.id = pharmacy.getId();
        this.address = pharmacy.getAddress();
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return new Address(address);
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return id == pharmacy.id &&
                address.equals(pharmacy.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", address=" + address +
                '}';
    }
}
