package lapr.project.controller;

import lapr.project.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class RegisterCourierControllerTest {

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
    void createNewInvalidCourierAlreadyEmail() {
        //Email already registered
        RegisterCourierController registerCourierController = new RegisterCourierController();
        Address address = new Address("a",0,0);
        PHUser phUser = new PHUser(0,1,address,"gabriel","123","gabriel@gmail.com");
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Courier courier = new Courier(0,phUser,pharmacy);
        boolean expected = false;

        Assertions.assertEquals(expected, registerCourierController.createNewCourier("julia","julia@gmail.com","123",pharmacy));
    }

    @Test
    void createNewCouriertoInvalidPharmacy() {
        //Email already registered
        RegisterCourierController registerCourierController = new RegisterCourierController();
        Address address = new Address("a",0,0);
        PHUser phUser = new PHUser(0,1,address,"gabriel","123","gabriel@gmail.com");
        Pharmacy pharmacy = new Pharmacy(2323,new Address("a",0,0));
        Courier courier = new Courier(0,phUser,pharmacy);
        boolean expected = false;

        Assertions.assertEquals(expected, registerCourierController.createNewCourier("jose alberto","josealberto@gmail.com","123",pharmacy));
    }

       @Test
    void createNewCourier() {
        RemoveCourierController controller = new RemoveCourierController();
        RegisterCourierController registerCourierController = new RegisterCourierController();
        System.out.println(controller.removeCourierByEmail("josealberto12@gmail.com"));

        Address address = new Address("aa",0,0,0);
        //PHUser phUser = new PHUser(0,1,address,"gabriel","123","gabriel@gmail.com");
        Pharmacy pharmacy = new Pharmacy(1,new Address("112",0.223f,0,0));
        Assertions.assertTrue(registerCourierController.createNewCourier("jose alberto","josealberto12@gmail.com","123",pharmacy));

        System.out.println(controller.removeCourierByEmail("josealberto12@gmail.com"));
    }

}