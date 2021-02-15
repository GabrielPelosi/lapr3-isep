package lapr.project.controller;

import lapr.project.model.Pharmacy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AddScooterParkControllerTest {

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
    void addScooterParkToPharmacy() {
        AddScooterParkController addScooterParkController = new AddScooterParkController();
        Assertions.assertTrue(addScooterParkController.addScooterParkToPharmacy(23,23,new Pharmacy(1,null)));
    }

    @Test
    void addScooterParkToInvalidPharmacy() {
        AddScooterParkController addScooterParkController = new AddScooterParkController();
        Assertions.assertFalse(addScooterParkController.addScooterParkToPharmacy(23,23,new Pharmacy(999,null)));
    }

}