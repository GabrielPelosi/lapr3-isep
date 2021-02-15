package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BackOrderTest {

    private Address add1 = new Address("x", 12f, 12f, 12f);
    private Pharmacy ph1 = new Pharmacy(1, add1);
    private Pharmacy ph2 = new Pharmacy(2, add1);

    private Product pd1 = new Product(1, "x", 30.0, 30.0, 1);

    private BackOrder bOrder = new BackOrder(1, ph1, ph2, pd1, 10);


    @Test
    void getAskPharmacyTest() {
Pharmacy expected = ph1;
Pharmacy result = bOrder.getAskPharmacy();

        Assertions.assertEquals(expected, result);

    }

    @Test
    void getSrcPharmacyTest() {

        Pharmacy expected = ph2;
        Pharmacy result = bOrder.getSrcPharmacy();

        Assertions.assertEquals(expected, result);


    }

    @Test
    void getProductTest() {
        Product expected = pd1;
        Product result = bOrder.getProduct();

        Assertions.assertEquals(expected, result);

    }

    @Test
    void getStockTest() {

        long expected = 10;

        long result = bOrder.getStock();

        Assertions.assertEquals(expected, result);


    }
}
