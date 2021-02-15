package lapr.project.controller;

import lapr.project.model.ParkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class RemoveVehicleParkControllerTest {

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
    void removeDroneParkById() {
        RemoveDroneParkController controller = new RemoveDroneParkController();
        long id = new ParkService().getLastParkCreated();
        System.out.println(id);
        Assertions.assertTrue(controller.removeDroneParkById(id));
    }

    @Test
    void removeDroneParkByIdInvalid() {
        RemoveDroneParkController controller = new RemoveDroneParkController();
        Assertions.assertFalse(controller.removeDroneParkById(999999));
    }
}