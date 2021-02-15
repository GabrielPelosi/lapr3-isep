package lapr.project.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AddDroneControllerTest {

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
    void addDrone() {
        AddDroneController addDroneController = new AddDroneController();
        Assertions.assertTrue(addDroneController.addDrone(1,23,100,70,0.13,1,15));
    }
    @Test
    void addDroneInvalid() {
        AddDroneController addDroneController = new AddDroneController();

        Assertions.assertFalse(addDroneController.addDrone(2332,223,100,70,0.13,1,15));
    }
}