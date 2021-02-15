package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void getId() {
        Vehicle vehicle = new Vehicle(1,
                new Pharmacy(1,
                        new Address("a", 0, 0)),400f);

        long expected = 1;
        Assertions.assertEquals(expected, vehicle.getId());
    }

    @Test
    void setId() {
        Vehicle vehicle = new Vehicle(1,
                new Pharmacy(1,
                        new Address("a",  0, 0)), 400f);

        long expected = 3;
        vehicle.setId(3);
        Assertions.assertEquals(expected, vehicle.getId());
    }

    @Test
    void getPharmacy() {
        Vehicle scooter = new Vehicle(1,
                new Pharmacy(1,
                        new Address("a", 0, 0)), 400f);

        long expected = 1;
        Assertions.assertEquals(expected, scooter.getPharmacy().getId());
    }

    @Test
    void setPharmacy() {
        Vehicle scooter = new Vehicle(1,
                new Pharmacy(1,
                        new Address("a", 0, 0)), 400f);

        Pharmacy expected = new Pharmacy(1, new Address("a",  0, 0));
        scooter.setPharmacy(expected);

        Assertions.assertEquals(expected.getId(), scooter.getPharmacy().getId());
    }

    @Test
    void getBatCapacity() {
        Vehicle scooter = new Vehicle(1, new Pharmacy(1,
                new Address("a", 0, 0)), 400f);

        float expected = 400f;
        Assertions.assertEquals(expected, scooter.getBatCapacity());
    }

    @Test
    void setBatCapacity() {
        Vehicle scooter = new Vehicle(1, new Pharmacy(1,
                new Address("a", 0, 0)), 400f);

        float expected = 600f;
        scooter.setBatCapacity(600f);
        Assertions.assertEquals(expected, scooter.getBatCapacity());
    }

    @Test
    void SetPharmacy() {
        Vehicle scooter = new Vehicle(1,
                new Pharmacy(1,
                        new Address("a",0,0)),400f);

        Pharmacy expected = new Pharmacy(1, new Address("a",0,0));
        scooter.setPharmacy(expected);

        Assertions.assertEquals(expected.getId(),scooter.getPharmacy().getId());
    }

    @Test
    void GetBatCapacity() {
        Vehicle scooter = new Vehicle(1, new Pharmacy(1,
                new Address("a",0,0)),400f);

        float expected = 400f;
        Assertions.assertEquals(expected,scooter.getBatCapacity());
    }

    @Test
    void SetBatCapacity() {
        Vehicle scooter = new Vehicle(1, new Pharmacy(1,
                new Address("a",0,0)),400f);

        float expected = 600f;
        scooter.setBatCapacity(600f);
        Assertions.assertEquals(expected,scooter.getBatCapacity());
    }

    @Test
    void setMax_battery() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );

        float expected = 400f;
        scooter.setMax_battery(400f);
        Assertions.assertEquals(expected,scooter.getMax_battery());
    }

    @Test
    void getActual_battery() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );

        float expected = 300f;
        scooter.setActual_battery(300f);
        Assertions.assertEquals(expected,scooter.getActual_battery());
    }

    @Test
    void setActual_battery() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );

        double expected = 0.3;
        scooter.setAerodinamic(0.3);
        Assertions.assertEquals(expected,scooter.getAerodinamic());
    }

    @Test
    void setAerodinamic() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );

        double expected = 0.3;
        scooter.setAerodinamic(0.3);
        Assertions.assertEquals(expected,scooter.getAerodinamic());
    }

    @Test
    void setFrontarea() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );

        double expected = 1.5;
        scooter.setFrontarea(1.5);
        Assertions.assertEquals(expected,scooter.getFrontarea());
    }

    @Test
    void setWeight() {
        Vehicle scooter=new Vehicle(1,new Pharmacy(1,new Address("a",0,0)),300,400,64,0.3,1.5,51 );
        double expected = 51;
        scooter.setWeight(51);
        Assertions.assertEquals(expected,scooter.getWeight());
    }
}