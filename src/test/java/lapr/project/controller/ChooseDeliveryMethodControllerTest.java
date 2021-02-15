package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.utils.graphmap.Edge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChooseDeliveryMethodControllerTest {

    ChooseDeliveryMethodController distanceController;
    ChooseDeliveryMethodController energyController;
    ChooseDeliveryMethodController invalidController;



    @BeforeAll
    void setUp(){
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
        Address ad1 = new Address(41.15227f, -8.60929f, 104f);
        Address ad2 = new Address(41.16875f, -8.68995f, 4f);
        Address ad3 = new Address(41.14582f, -8.61398f, 87f);
        Costumer c1 = new Costumer(ad1);
        Costumer c2 = new Costumer(ad2);
        Costumer c3 = new Costumer(ad3);
        UserOrder us1 = new UserOrder(c1);
        UserOrder us2 = new UserOrder(c2);
        UserOrder us3 = new UserOrder(c3);
        List<UserOrder> l = new LinkedList<>();
        l.add(us1);
        l.add(us2);
        l.add(us3);
        Delivery del = new Delivery(new Vehicle(1),1, l);
        distanceController = new ChooseDeliveryMethodController(del, 0);
        energyController = new ChooseDeliveryMethodController(del, 1);
        invalidController = new ChooseDeliveryMethodController(del, 2);

    }


    /*
    @Test
    void pickShortestRoute() {
        Route r1 = distanceController.getLandBasedRoute();
        Route r2 = distanceController.getAirBasedRoute();
        assertNull(r1);
        assertNull(r2);
        r1 = energyController.getLandBasedRoute();
        r2 = energyController.getAirBasedRoute();
        assertNull(r1);
        assertNull(r2);
        r1 = invalidController.getLandBasedRoute();
        assertNull(r1);
    }

     */


    @Test
    void shortestOfTwoRoutes() {
        List<Edge<Address, Integer>> l = new LinkedList<>();
        l.add(new Edge<>(null, 1, null, null));
        Route r1 = new Route(l);
        l.add(new Edge<>(null, 1, null, null));
        Route r2 = new Route(l);
        Route menor = distanceController.shortestOfTwoRoutes(r1, r2);
        assertEquals(menor, r1);
        menor = distanceController.shortestOfTwoRoutes(r2,r1);
        assertEquals(menor, r1);
    }
}