package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.Pharmacy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class RemoveCourierControllerTest {


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
    void removeInvalidCourierByEmail() {
        RemoveCourierController removeCourierController = new RemoveCourierController();
        String invalidEmail = "aaa";
        Assertions.assertFalse(removeCourierController.removeCourierByEmail(invalidEmail));
    }

    @Test
    void removeCourierByEmail() {
        RemoveCourierController removeCourierController = new RemoveCourierController();
        RegisterCourierController registerCourierController = new RegisterCourierController();
        String email = "josealberto@gmail.com";

        System.out.println(removeCourierController.removeCourierByEmail(email));

        Pharmacy pharmacy = new Pharmacy(1,new Address("112",0.223f,0,0));
        System.out.println(registerCourierController.createNewCourier("jose alberto","josealberto@gmail.com","123",pharmacy));


        Assertions.assertTrue(removeCourierController.removeCourierByEmail(email));
    }
}