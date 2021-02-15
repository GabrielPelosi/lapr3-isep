package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.Pharmacy;
import lapr.project.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getNearestPharmacyControllerTest {

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
    void getNearestPharmacyWithPorductTest(){

        getNearestPharmacyController ctlr = new getNearestPharmacyController();
        Address add = new Address(41.172478f,-8.669461f);
        Address add2 = new Address(41.16875f,-8.68995f);
        Pharmacy ask = new Pharmacy(1,add);
        Product prod = new Product(1,"x",32.2,.1,10);
        Pharmacy result = ctlr.getNearestPharmacyWithProduct(ask,prod,1) ;
        long expected = 2;
        Assertions.assertEquals(expected,result.getId());
        Assertions.assertEquals(41.16875f,result.getAddress().getLat());
        Assertions.assertEquals(-8.68995f,result.getAddress().getLon());
        Assertions.assertEquals(1,result.getAddress().getElevation());
    }
}
