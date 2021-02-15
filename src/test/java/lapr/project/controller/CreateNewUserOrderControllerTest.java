package lapr.project.controller;

import lapr.project.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class CreateNewUserOrderControllerTest {

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
    void createNewOrder() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,0.5,1));
        products.add(new Product(2,"bb",23.4,0.8,2));
        products.add(new Product(3,"cc",23.4,0.7,3));
        products.add(new Product(4,"aaa",23.4,0.5,50));
        products.add(new Product(7,"aaa",23.4,0.5,20));
        Costumer costumer = new Costumer(1,null,0,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertTrue(controller.createNewOrder(products,costumer,0,pharmacy,false));

    }

    @Test
    void createNewOrderAndPayCredits() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,0.5,1));
        products.add(new Product(2,"bb",23.4,0.8,2));
        products.add(new Product(3,"cc",23.4,0.7,3));
        Costumer costumer = new Costumer(1,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertTrue(controller.createNewOrder(products,costumer,0,pharmacy,true));

    }

    @Test
    void createNewIrderAndHasNOCredits() {
        //invalid pharmacy
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,1,1));
        products.add(new Product(2,"bb",23.4,0.8,1));
        products.add(new Product(3,"cc",23.4,0.4,1));
        Costumer costumer = new Costumer(3,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertTrue(controller.createNewOrder(products,costumer,0,pharmacy,true));

    }

    @Test
    void createNewInvalidOrder() {
        //invalid costumer
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,0.4,1));
        products.add(new Product(2,"bb",23.4,0.4,1));
        products.add(new Product(3,"cc",23.4,1.4,1));
        Costumer costumer = new Costumer(444444,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertFalse(controller.createNewOrder(products,costumer,0,pharmacy,false));

    }

    @Test
    void createNewInvalid2Order() {
        //invalid pharmacy
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,0.9,1));
        products.add(new Product(2,"bb",23.4,0.8,2));
        products.add(new Product(3,"cc",23.4,0.4,3));
        Costumer costumer = new Costumer(1,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(3232323,new Address("a",0,0));
        Assertions.assertFalse(controller.createNewOrder(products,costumer,0,pharmacy,false));

    }

    @Test
    void createNewInvalidOrderEmptyProducts() {
        //invalid costumer
        List<Product> products = new ArrayList<>();
        Costumer costumer = new Costumer(444444,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertFalse(controller.createNewOrder(products,costumer,0,pharmacy,false));

    }

    @Test
    void createNewInvalidWeight() {
        //invalid pharmacy
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,10,1));
        products.add(new Product(2,"bb",23.4,0.8,2));
        products.add(new Product(3,"cc",23.4,0.4,3));
        Costumer costumer = new Costumer(1,null,23,9009);
        UserOrder userOrder = new UserOrder(1,costumer,products,23);
        CreateNewUserOrderController controller = new CreateNewUserOrderController();
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Assertions.assertFalse(controller.createNewOrder(products,costumer,0,pharmacy,false));

    }
}