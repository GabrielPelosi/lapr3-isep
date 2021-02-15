package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class CostumerServiceTest {

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
    void updateCredtisOfCostumer() {
        CostumerService costumerService = new CostumerService();
        boolean expected = true;
        Assertions.assertEquals(expected,costumerService.updateCredtisOfCostumerById(1,33000));
    }

    @Test
    void updateCredtisOfInvalidCostumer() {
        CostumerService costumerService = new CostumerService();
        boolean expected = false;
        Assertions.assertEquals(expected,costumerService.updateCredtisOfCostumerById(2323,12));
    }


    @Test
    void hasEnoughCreditsById() {
        CostumerService costumerService = new CostumerService();
        long costumerID = 2;
        Assertions.assertTrue(costumerService.hasEnoughCreditsById(costumerID));
    }

    @Test
    void hasEnoughCreditsByIdFalse() {
        CostumerService costumerService = new CostumerService();
        long costumerID = 23;
        Assertions.assertFalse(costumerService.hasEnoughCreditsById(costumerID));
    }

    @Test
    void hasEnoughCreditsByIdInvalid() {
        CostumerService costumerService = new CostumerService();
        long costumerID = 333333;
        Assertions.assertFalse(costumerService.hasEnoughCreditsById(costumerID));
    }

    @Test
    void payDeliveryTaxWithCredits() {
        CostumerService costumerService = new CostumerService();
        long costumerID = 1;
        Assertions.assertTrue(costumerService.payDeliveryTaxWithCredits(costumerID));
    }

    @Test
    void payDeliveryTaxWithCreditsInvalid() {
        CostumerService costumerService = new CostumerService();
        long costumerID = 9999;
        Assertions.assertFalse(costumerService.payDeliveryTaxWithCredits(costumerID));
    }
}