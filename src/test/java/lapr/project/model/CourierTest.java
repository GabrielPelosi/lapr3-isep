package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourierTest {

    @Test
    void getId() {
        Courier courier = new Courier(
                1,new PHUser(
                        1,1,new Address(
                "a",0,0),"aa","aa","aa"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));
        long expected = 1;
        Assertions.assertEquals(expected,courier.getId());
    }

    @Test
    void setId() {
        Courier courier = new Courier(
                1,new PHUser(
                1,1,new Address(
                "a",0,0),"aa","aa","aa"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));
        long expected = 2;
        courier.setId(2);
        Assertions.assertEquals(expected,courier.getId());
    }

    @Test
    void getPhUser() {
        Courier courier = new Courier(
                1,new PHUser(
                1,1,new Address(
                "a",0,0),"joao123","1334","jojoao@isep.ipp"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));

        PHUser phUser = new PHUser(
                1,32,new Address(
                "a",3232,323),"joao123","1334","jojoao@isep.ipp");

        Assertions.assertEquals(phUser.getId(),courier.getPhUser().getId());
        Assertions.assertEquals(phUser.getUserName(),courier.getPhUser().getUserName());
        Assertions.assertEquals(phUser.getEmail(),courier.getPhUser().getEmail());
        Assertions.assertEquals(phUser.getPasswd(),courier.getPhUser().getPasswd());
    }

    @Test
    void setPhUser() {
        Courier courier = new Courier(
                1,new PHUser(
                1,1,new Address(
                "a",0,0),"joao123","1334","jojoao@isep.ipp"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));

        PHUser phUser2 = new PHUser(
                2,32,new Address(
                "a",3232,323),"jose123","12","jose@isep.pt");
        courier.setPhUser(phUser2);

        Assertions.assertEquals(phUser2.getId(),courier.getPhUser().getId());
        Assertions.assertEquals(phUser2.getUserName(),courier.getPhUser().getUserName());
        Assertions.assertEquals(phUser2.getEmail(),courier.getPhUser().getEmail());
        Assertions.assertEquals(phUser2.getPasswd(),courier.getPhUser().getPasswd());
    }

    @Test
    void getPharmacy() {
        Courier courier = new Courier(
                1,new PHUser(
                1,1,new Address(
                "a",0,0),"aa","aa","aa"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));

        Pharmacy pharmacy = new Pharmacy(1,new Address("a",1,2));
        Assertions.assertEquals(pharmacy.getId(), courier.getPharmacy().getId());
        Assertions.assertEquals(pharmacy.getAddress().getLon(), courier.getPharmacy().getAddress().getLon());
    }

    @Test
    void setPharmacy() {
        Courier courier = new Courier(
                1,new PHUser(
                1,1,new Address(
                "a",0,0),"aa","aa","aa"),
                new Pharmacy(
                        1,new Address(
                        "a",1,2)));
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",1,2));
        courier.setPharmacy(pharmacy);
        Assertions.assertEquals(pharmacy.getId(), courier.getPharmacy().getId());
        Assertions.assertEquals(pharmacy.getAddress().getLon(), courier.getPharmacy().getAddress().getLon());
    }
}