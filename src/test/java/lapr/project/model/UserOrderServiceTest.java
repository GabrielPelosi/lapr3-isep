package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

class UserOrderServiceTest {


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
    void createNewUserOrder() {
        Costumer costumer = new Costumer(1, null, 23, 9009);
        UserOrderService userOrderService = new UserOrderService();

        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertTrue(userOrderService.createNewUserOrder(costumer,pharmacy, 3));


    }

    @Test
    void createNewInvalidUserOrder() {
        Costumer costumer = new Costumer(3232, null, 23, 9009);
        UserOrderService userOrderService = new UserOrderService();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertFalse(userOrderService.createNewUserOrder(costumer,pharmacy,4));

    }

    @Test
    void getLastUserOrderIdCreated() {
        UserOrderService userOrderService = new UserOrderService();
        long expected = 1;
        Assertions.assertNotEquals(expected, userOrderService.getLastUserOrderCreated());
    }

    @Test
    void addProductsToInvalidOrder() {
        UserOrderService userOrderService = new UserOrderService();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "aaa", 23.4, 23.4, 1));
        products.add(new Product(2, "bb", 23.4, 23.4, 2));
        products.add(new Product(3, "cc", 23.4, 23.4, 3));
        //82 id of userOrderForTesting
        for (Product product : products) {
            Assertions.assertFalse(userOrderService.addProductsToCreatedOrder(9999999, product.getId(), product.getQuantity()));
        }
    }

    @Test
    void updateDeliveryUser() {
        UserOrderService userOrderService = new UserOrderService();
        long id_delivery= userOrderService.getLastDelivery();
        long id_order= userOrderService.getLastUserOrderCreated();
            Assertions.assertTrue(userOrderService.updateDeliveryUser(id_order,id_delivery));

    }

    @Test
    void checkDeliveryTest(){
        UserOrderService us = new UserOrderService();
        UserOrder u1 = new UserOrder(2, null, null, null, 2, 2);
        Assertions.assertTrue(us.checkDelivery(u1));
    }
}
