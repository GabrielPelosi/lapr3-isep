package lapr.project.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CheckProdductHasStockControllerTest {

private CheckProductHasStockController ctrl;

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
    void checkStockTest(){

    ctrl = new CheckProductHasStockController();

    long result = ctrl.getProductInPharmacy(1,1);
    long expected = result;

        Assertions.assertEquals(expected, result);


    }

}
