package lapr.project.model;

import lapr.project.controller.RemoveDronecontroller;
import lapr.project.controller.RemoveScooterController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class VehicleServiceTest {
    @BeforeAll
    public static void setUp() {
        try {
            Properties properties =
                    new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void addValidScooter() {
        VehicleService vehicleService = new VehicleService();
        boolean expected = true;
        Assertions.assertEquals(expected, vehicleService.addScooter(1, 23, 100, 70, 0.13, 1, 15));
        Assertions.assertEquals(expected, vehicleService.addScooter(2, 23, 100, 70, 0.13, 1, 15));
    }


    @Test
    void addValidDrone() {
        VehicleService vehicleService = new VehicleService();
        boolean expected = true;
        Assertions.assertEquals(expected, vehicleService.addDrone(1, 23, 100, 70, 0.13, 1, 15));

    }



    @Test
    void addScooterToInvalidPharmacy() {
        VehicleService vehicleService = new VehicleService();
        long invalidPharmacyId = 70;
        float batCapacity = 500f;
        boolean expected = false;
        Assertions.assertEquals(expected, vehicleService.addDrone(invalidPharmacyId, 23, 100, 70, 0.13, 1, 15));
    }



    @Test
    void addScooterToInvalidPharmacy2() {
        VehicleService vehicleService = new VehicleService();
        long invalidPharmacyId = 70;
        float batCapacity = 500f;
        boolean expected = false;
        Assertions.assertEquals(expected, vehicleService.addScooter(3232, 23, 100, 70, 0.13, 1, 15));
    }

    @Test
    void removeScooterById() {
        RemoveScooterController removeScooterController = new RemoveScooterController();
        long valid_id = new VehicleService().getlastScooter();
        boolean expected = true;
        Assertions.assertEquals(expected, removeScooterController.removeScooterById(valid_id));
    }

    @Test
    void removeDroneByid() {
        RemoveDronecontroller removeDronecontroller = new RemoveDronecontroller();
        long valid_id = new VehicleService().getlastDrone();
        boolean expected = true;
        Assertions.assertEquals(expected, removeDronecontroller.removeDroneById(valid_id));
    }

    @Test
    void removeDroneByInvalidid() {
        RemoveDronecontroller removeDronecontroller = new RemoveDronecontroller();
        long invalid_id = new VehicleService().getlastDrone();
        invalid_id = invalid_id +100;
        Assertions.assertFalse(removeDronecontroller.removeDroneById(invalid_id));
    }
    
    @Test
    void removeScooterByInvalidId() {
        RemoveScooterController removeScooterController = new RemoveScooterController();
        long invalid_id =9999;
        Assertions.assertFalse(removeScooterController.removeScooterById(invalid_id));
    }
}