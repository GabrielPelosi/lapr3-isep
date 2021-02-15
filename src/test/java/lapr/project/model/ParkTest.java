package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkTest {

    @Test
    void getId() {
        Park park = new Park(1, 30, 23);
        long expected = 1;
        Assertions.assertEquals(expected, park.getId());
    }

    @Test
    void setId() {
        Park park = new Park(1, 30, 23);
        long expected = 23;
        park.setId(23);
        Assertions.assertEquals(expected, park.getId());
    }

    @Test
    void getnCharginsSlot() {
        Park park = new Park(1, 30, 23);
        int expected = 30;
        Assertions.assertEquals(expected, park.getnCharginsSlot());
    }

    @Test
    void setnCharginsSlot() {
        Park park = new Park(1, 30, 23);
        int expected = 70;
        park.setnCharginsSlot(70);
        Assertions.assertEquals(expected, park.getnCharginsSlot());
    }

    @Test
    void getnParkingsSlot() {
        Park park = new Park(1, 30, 23);
        int expected = 23;
        Assertions.assertEquals(expected, park.getnParkingsSlot());
    }

    @Test
    void setnParkingsSlot() {
        Park park = new Park(1, 30, 23);
        int expected = 40;
        park.setnParkingsSlot(40);
        Assertions.assertEquals(expected, park.getnParkingsSlot());
    }

    @Test
    void getPharamcy() {
        Park park = new Park(1, 30, 23, new Pharmacy(1, null));
        int expected = 1;
        Assertions.assertEquals(expected, park.getPharmacy().getId());
    }

    @Test
    void setPharmacy() {
        Park park = new Park(1, 30, 23, new Pharmacy(1, null));
        Address add = new Address(11f, 11f);
        Pharmacy ph = new Pharmacy(1, add);

        Pharmacy expected = ph;
        park.setPharmacy(ph);
        Pharmacy result = park.getPharmacy();

        Assertions.assertEquals(expected, result);
    }
}