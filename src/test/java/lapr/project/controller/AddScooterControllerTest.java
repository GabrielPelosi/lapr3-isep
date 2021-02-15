package lapr.project.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class AddScooterControllerTest {

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
    void addScooter() {
        AddScooterController addScooterController = new AddScooterController();
        boolean expected = true;
        Assertions.assertTrue(addScooterController.addScooter(1,23,100,70,0.13,1,15));
    }

    @Test
    void addScooterInvalid() {
        AddScooterController addScooterController = new AddScooterController();
        boolean expected = false;
        Assertions.assertEquals(expected, addScooterController.addScooter(2332,23,100,70,0.13,1,15));
    }
}