package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DeliveryTest {

    Vehicle v = new Vehicle(1,new Pharmacy(1,new Address(14f,14f)),1);
    List<UserOrder> listax = new ArrayList<>();
    Delivery delivery=new Delivery(1,v,123,listax,new Pharmacy(1,new Address(14f,14f)));

    @Test
    void getIdvehicle() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        Delivery delivery=new Delivery(new Vehicle(11,new Pharmacy(1,null),12) ,12,lista);
        double expected = 11;
        delivery.setIdvehicle(new Vehicle(11,new Pharmacy(1,null),1));
        Assertions.assertEquals(expected,delivery.getIdvehicle().getId());

    }

    @Test
    void setIdvehicle() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        Delivery delivery=new Delivery(new Vehicle(11,new Pharmacy(1,null),12) ,12,lista);
        double expected = 11;
       delivery.setIdvehicle(new Vehicle(11,new Pharmacy(1,null),12));
        Assertions.assertEquals(expected,delivery.getIdvehicle().getId());
    }

    @Test
    void getWeight() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        long weight=12;
        Delivery del=new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),weight,lista);
        Delivery delivery=new Delivery(del);
        double expected = 12;
        delivery.setWeight(12);
        Assertions.assertEquals(expected,del.getWeight());
    }

    @Test
    void setWeight() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        long weight=12;
        Delivery delivery=new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),weight,lista);
        double expected = 12;
        delivery.setWeight(12);
        Assertions.assertEquals(expected,delivery.getWeight());
    }

    @Test
    void setPharmacy() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        Pharmacy pharmacy=new Pharmacy(1,null);
        Delivery delivery=new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),12,lista);
        Pharmacy expected = pharmacy;
        delivery.setPharmacy(pharmacy);
        Assertions.assertEquals(expected,delivery.getPharmacy());
    }

    @Test
    void getUserOrderList() {
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        Pharmacy pharmacy=new Pharmacy(1,null);
        Delivery delivery=new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),12,lista);
        List<UserOrder> expected = delivery.getUserOrderList();
        Assertions.assertEquals(expected,delivery.getUserOrderList());

        expected = new ArrayList<>();

        Delivery delivery2 =new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),12,expected);
        Assertions.assertEquals(expected,delivery2.getUserOrderList());
    }

    @Test
void getIdDeliveryTest(){
        List<UserOrder> lista = new ArrayList<>();
        UserOrder u1 = new UserOrder(1, null, null, null, 2, 2);
        UserOrder u2 = new UserOrder(2, null, null, null, 1, 2);
        UserOrder u3 = new UserOrder(3, null, null, null, 2, 2);
        UserOrder u4 = new UserOrder(4, null, null, null, 3, 2);
        UserOrder u5 = new UserOrder(5, null, null, null, 1, 2);
        UserOrder u6 = new UserOrder(21, null, null, null, 2, 2);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        lista.add(u4);
        lista.add(u5);
        lista.add(u6);
        Pharmacy pharmacy=new Pharmacy(1,null);
        Delivery delivery=new Delivery(1,(new Vehicle(11,new Pharmacy(1,null),1)),12,lista,pharmacy);
        long expected = 1;
        Assertions.assertEquals(expected,delivery.getIdDelivery());


        Delivery delivery2=new Delivery((new Vehicle(11,new Pharmacy(1,null),1)),12,lista);
        expected = 0;
        Assertions.assertEquals(expected,delivery2.getIdDelivery());

    }




}