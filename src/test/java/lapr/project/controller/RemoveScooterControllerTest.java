package lapr.project.controller;

import lapr.project.model.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class RemoveScooterControllerTest {

    @BeforeAll
    public static void setUp(){
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
    void removeScooterById() {
        RemoveScooterController removeScooterController = new RemoveScooterController();
        long valid_id = new VehicleService().getlastScooter();
        boolean expected = true;
        Assertions.assertEquals(expected, removeScooterController.removeScooterById(valid_id));
    }


    @Test
    void removeScooterByInvalidId() {
        RemoveScooterController removeScooterController = new RemoveScooterController();
        long invalid_id =9999;
        Assertions.assertFalse(removeScooterController.removeScooterById(invalid_id));
    }
    
    @Test
    void removeDroneByInvalidId() {
        VehicleService vehicleService=new VehicleService();
        long invalid_id = new VehicleService().getlastDrone();
        invalid_id = invalid_id +100;
        Assertions.assertFalse(vehicleService.isVehicleExistsById(invalid_id));
    }
}