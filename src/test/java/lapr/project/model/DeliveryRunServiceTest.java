package lapr.project.model;

import lapr.project.data.Delivery_RunDB;
import lapr.project.data.UserOrderDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class DeliveryRunServiceTest {
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
    void addDeliveries() {
        List<UserOrder> lista = new ArrayList<>();
        DeliveryRunService deliveryRunService = new DeliveryRunService();
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
        Assertions.assertTrue(deliveryRunService.addDelivery(vehicle, lista, new Pharmacy(1, null)));
    }

    @Test
    void addDeliveriesEmptyList() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        lista.add(u1);
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        Vehicle vehicle=new Vehicle(4,new Pharmacy(1,null),12);

        Assertions.assertFalse(deliveryRunService.addDelivery(vehicle, lista, new Pharmacy(1, null)));
    }

    @Test
    void VehicleIstFree() {
        Delivery_RunDB delivery_runDB=new Delivery_RunDB();
        Vehicle vehicle=new Vehicle(4,new Pharmacy(1,null),12);
        Assertions.assertTrue(delivery_runDB.vehicleFree(vehicle));
    }

    @Test
    void createDelivery() {
        List<UserOrder> lista = new ArrayList<>();
        Delivery_RunDB delivery_runDB = new Delivery_RunDB();
        UserOrderService userOrderService=new UserOrderService();
        UserOrderDB userOrderDB=new UserOrderDB();
        Costumer costumer = new Costumer(1, null, 23, 9009);
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        userOrderService.createNewUserOrder(costumer, pharmacy, 3);
        long id_user_run_null=userOrderDB.getUserDeliveryNull();
        System.out.println(id_user_run_null);
        UserOrder u6 = new UserOrder(id_user_run_null, null, null, null, 2, 2);
        lista.add(u6);
        Vehicle vehicle=new Vehicle(4,new Pharmacy(1,null),12);

        Assertions.assertTrue(delivery_runDB.createDelivery(new Delivery(vehicle, 12, lista,pharmacy)));
    }

    @Test
    void removeDeliveriesRunOfSpecificScooter() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long valid_scooter = 11;
        Assertions.assertTrue(deliveryRunService.removeDeliveriesRunOfSpecificScooter(valid_scooter));
    }
    @Test
    void removeDeliveriesRunOfSpecificInvScooter() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long valid_scooter = 3;
        Assertions.assertFalse(deliveryRunService.removeDeliveriesRunOfSpecificScooter(valid_scooter));
    }

    @Test
    void removeDeliveriesRunOfSpecificDrone() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long valid_drone = 11;
        boolean expected = true;
        Assertions.assertTrue(deliveryRunService.removeDeliveriesRunOfSpecificDrone(valid_drone));
    }
    @Test
    void removeDeliveriesRunOfSpecificInvalidDrone() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long valid_drone = 3;
        boolean expected = true;
        Assertions.assertFalse(deliveryRunService.removeDeliveriesRunOfSpecificDrone(valid_drone));
    }

    @Test
    void updateState() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long id_delivery = 3;
        long state = 2;
        Assertions.assertTrue( deliveryRunService.updateState(id_delivery, state));
    }
    @Test
    void updateInvalidState() {
        DeliveryRunService deliveryRunService = new DeliveryRunService();
        long id_delivery = 3;
        long state = 4;
        Assertions.assertFalse(deliveryRunService.updateState(id_delivery, state));
    }
    @Test
    void checkIdDelivery() {
        List<UserOrder> lista = new ArrayList<>();
        Delivery_RunDB delivery_runDB = new Delivery_RunDB();
        UserOrderService userOrderService=new UserOrderService();
        UserOrderDB userOrderDB=new UserOrderDB();
        Costumer costumer = new Costumer(1, null, 23, 9009);
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        userOrderService.createNewUserOrder(costumer, pharmacy, 3);
        long id_user_run_null=userOrderDB.getUserDeliveryNull();
        UserOrder u6 = new UserOrder(id_user_run_null, null, null, null, 2, 2);
        lista.add(u6);
        Assertions.assertTrue(delivery_runDB.checkIdDelivery(u6));
    }

    @Test
    void checkInvalidIdDelivery() {
        List<UserOrder> lista = new ArrayList<>();
        Delivery_RunDB delivery_runDB = new Delivery_RunDB();
        UserOrder u1 = new UserOrder(2, null, null, null, 2, 2);
        lista.add(u1);
        Assertions.assertTrue(delivery_runDB.checkIdDelivery(u1));
    }
    @Test
    void checkvalidIdDelivery() {
        List<UserOrder> lista = new ArrayList<>();
        Delivery_RunDB delivery_runDB = new Delivery_RunDB();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        lista.add(u1);
        Assertions.assertFalse(delivery_runDB.checkIdDelivery(u1));
    }
}