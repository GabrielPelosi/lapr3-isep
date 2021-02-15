package lapr.project.controller;

import lapr.project.data.VehicleDB;
import lapr.project.model.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class RemoveDronecontrollerTest {

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
    void removeDroneByid() {
        RemoveDronecontroller removeDronecontroller = new RemoveDronecontroller();
        AddDroneController droneController = new AddDroneController();
        droneController.addDrone(2,3,4,8,9,9,7);
        long valid_id = new VehicleService().getlastDrone();
        System.out.println(valid_id);
        Assertions.assertTrue( removeDronecontroller.removeDroneById(valid_id));
    }

    @Test
    void removeDroneByInvalidid() {
        RemoveDronecontroller removeDronecontroller = new RemoveDronecontroller();
        long invalid_id = new VehicleService().getlastDrone();
        invalid_id = invalid_id +100;
        Assertions.assertFalse(removeDronecontroller.removeDroneById(invalid_id));
    }

    @Test
    void removeDroneByInvalidId() {
        VehicleService vehicleService=new VehicleService();
        long invalid_id = new VehicleService().getlastDrone();
        invalid_id = invalid_id +100;
        Assertions.assertFalse(vehicleService.isVehicleExistsById(invalid_id));
    }
}