package lapr.project.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class UpdateStockProductControllerTest {


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
    void updateStockProductById() {
        UpdateStockProductController updateStockProductController = new UpdateStockProductController();
        boolean expected = true;
        Assertions.assertEquals(expected,updateStockProductController.updateStockProductById(6,1,150));

    }
    @Test
    void updateStockProductByIdOfInvalidProduct() {
        UpdateStockProductController updateStockProductController = new UpdateStockProductController();
        boolean expected = false;
        Assertions.assertEquals(expected, updateStockProductController.updateStockProductById(2323,2,2));
    }
    @Test
    void updateStockProductByIdOfInvalidPharmacy() {
        UpdateStockProductController updateStockProductController = new UpdateStockProductController();
        boolean expected = false;
        Assertions.assertEquals(expected, updateStockProductController.updateStockProductById(1,2323,40));

    }
}