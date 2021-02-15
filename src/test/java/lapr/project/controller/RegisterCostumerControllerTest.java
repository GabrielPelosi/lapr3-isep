package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.Local;
import lapr.project.model.PHUser;
import lapr.project.model.Pharmacy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class RegisterCostumerControllerTest {

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
    void registerCostumerEmailAlreadyExists() {
        RegisterCostumerController registerCostumerController = new RegisterCostumerController();
        Address address = new Address("Cais da Ribeira",41.14063f,-8.61118f,25);
        Assertions.assertFalse(registerCostumerController.registerCostumer("gabriel","gabriel123323@gmail.com","123",address,999999999));
    }
}