package lapr.project.controller;

import lapr.project.data.UserOrderDB;
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

class DeliveryControllerTest {
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
    void addInvalidDelivery() {
        List <UserOrder> lista =new ArrayList<>();
        UserOrder u1=new UserOrder(1,null,null,null,2,2);
        UserOrder u2=new UserOrder(2,null,null,null,1,2);
        UserOrder u3=new UserOrder(3,null,null,null,2,2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        DeliveryController deliveryRunService = new DeliveryController();
        Assertions.assertFalse( deliveryRunService.addDelivery(new Vehicle(12,new Pharmacy(1,null),12), lista,new Pharmacy(1,null)));
    }

    @Test
    void addDeliveries() {
        List<UserOrder> lista = new ArrayList<>();
        DeliveryController deliveryRunService = new DeliveryController();
        UserOrderService userOrderService=new UserOrderService();
        UserOrderDB userOrderDB=new UserOrderDB();
        Costumer costumer = new Costumer(1, null, 23, 9009);
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        userOrderService.createNewUserOrder(costumer, pharmacy, 3);
        long id_user_run_null=userOrderDB.getUserDeliveryNull();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(id_user_run_null, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u6);
        System.out.println(id_user_run_null);
        Vehicle vehicle=new Vehicle(4,new Pharmacy(1,null),12);
        Assertions.assertTrue( deliveryRunService.addDelivery(vehicle, lista, new Pharmacy(1, null)));
    }
    @Test
    void updateState_Invalid_State() {
        DeliveryController deliveryController = new DeliveryController();
        Assertions.assertFalse( deliveryController.updateState(3,5));
    }
    @Test
    void updateStateValidState() {
        DeliveryController deliveryController = new DeliveryController();
        Assertions.assertTrue( deliveryController.updateState(3,1));
    }
    @Test
    void updateStateValidId() {
        DeliveryController deliveryController = new DeliveryController();
        Assertions.assertTrue( deliveryController.updateState(3,3));
    }
    @Test
    void updateStateInvalidId() {
        DeliveryController deliveryController = new DeliveryController();
        Assertions.assertFalse( deliveryController.updateState(99999,3));
    }
}