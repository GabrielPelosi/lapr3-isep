package lapr.project.controller;

import lapr.project.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AddPharmacyControllerTest {

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
    void addPharmacy() {
        AddPharmacyController addPharmacyController = new AddPharmacyController();
        Assertions.assertFalse(addPharmacyController.addPharmacy(new Address("Trindade",41.15227f,-8.60929f,104)));

    }

//    @Test
//    void addPharmacyVali() {
//        Random rand = new Random();
//        AddPharmacyController addPharmacyController = new AddPharmacyController();
//        Assertions.assertTrue(addPharmacyController.addPharmacy(new Address("Teste Add Pharamcy" + rand.nextInt(), rand.nextFloat(), rand.nextFloat(),123)));
//    }

}