package lapr.project.controller;

import lapr.project.model.Pharmacy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class AddVehicleParkControllerTest {


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
    void addDronePark() {
        AddDroneParkController addDroneParkController = new AddDroneParkController();
        Assertions.assertTrue(addDroneParkController.addDronePark(44,24,new Pharmacy(1,null)));
    }

    @Test
    void addDroneParkInvalidPharmacy() {
        AddDroneParkController addDroneParkController = new AddDroneParkController();
        Assertions.assertFalse(addDroneParkController.addDronePark(44,24,new Pharmacy(44453,null)));
    }
}