package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PharmacyTest {
    Pharmacy pharmacy = new Pharmacy(1,
            new Address("a",0,0));
    Pharmacy phCopy = new Pharmacy(pharmacy);


    @Test
    void getId() {
        Pharmacy pharmacy = new Pharmacy(1,
                new Address("a",0,0));
        long expected = 1;
        Assertions.assertEquals(expected,pharmacy.getId());
    }

    @Test
    void setId() {
        Pharmacy pharmacy = new Pharmacy(1,
                new Address("a",0,0));
        long expected = 23;
        pharmacy.setId(23);
        Assertions.assertEquals(expected,pharmacy.getId());
    }

    @Test
    void getAddress() {
        Pharmacy pharmacy = new Pharmacy(1,
                new Address("a",0,0)
        );

        Address expectedAddress = new Address("a",0,0);

        Assertions.assertEquals(expectedAddress.getLat(),pharmacy.getAddress().getLat());
        Assertions.assertEquals(expectedAddress.getLon(),pharmacy.getAddress().getLon());

    }

    @Test
    void setAddress() {
        Pharmacy pharmacy = new Pharmacy(1,
                new Address("a",0,0));

        Address expectedAddress = new Address("a",0,0);

        pharmacy.setAddress(expectedAddress);

        Assertions.assertEquals(expectedAddress.getLat(),pharmacy.getAddress().getLat());
        Assertions.assertEquals(expectedAddress.getLon(),pharmacy.getAddress().getLon());
    }



}