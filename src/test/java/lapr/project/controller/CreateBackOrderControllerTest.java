package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.BackOrder;
import lapr.project.model.Pharmacy;
import lapr.project.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreateBackOrderControllerTest {


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
    void addBackOrderTest(){
        Address add1 = new Address("x",12f,12f,12f);
        Pharmacy ph1 = new Pharmacy(1,add1);
        Pharmacy ph2 = new Pharmacy(2,add1);

        Product pd1 = new Product(1,"x",30.0,30.0,1);



        CreateBackOrderController ctrl = new CreateBackOrderController();

        Assertions.assertTrue(ctrl.createBackOrder(ph1,ph2,pd1,10));





    }
}


