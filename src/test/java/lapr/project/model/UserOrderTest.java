package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class UserOrderTest {

    @Test
    void getId() {
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        long expected = 1;
        Assertions.assertEquals(expected,userOrder.getId());
    }

    @Test
    void setId() {
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        long expected = 3;
        userOrder.setId(3);
        Assertions.assertEquals(expected,userOrder.getId());
    }

    @Test
    void getCostumer() {
        UserOrder userOrder = new UserOrder(1,new Costumer(1,null,12,32),new LinkedList<>(),23);
        Costumer expected = new Costumer(1,null,12,32);
        Assertions.assertEquals(expected.getId(),userOrder.getCostumer().getId());
        Assertions.assertEquals(expected.getNif(),userOrder.getCostumer().getNif());
        Assertions.assertEquals(expected.getCred(),userOrder.getCostumer().getCred());
    }

    @Test
    void setCostumer() {
        UserOrder userOrder = new UserOrder(1,new Costumer(1,null,12,32),new LinkedList<>(),23);
        Costumer expected = new Costumer(1,null,12,32);
        userOrder.setCostumer(expected);
        Assertions.assertEquals(expected.getId(),userOrder.getCostumer().getId());
        Assertions.assertEquals(expected.getNif(),userOrder.getCostumer().getNif());
        Assertions.assertEquals(expected.getCred(),userOrder.getCostumer().getCred());
    }

    @Test
    void getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,23.4,123));
        products.add(new Product(2,"bb",23.4,23.4,123));
        products.add(new Product(3,"cc",23.4,23.4,123));
        UserOrder userOrder = new UserOrder(1,null,products,23);


        Assertions.assertEquals(products.get(0).getId(),userOrder.getProducts().get(0).getId());
        Assertions.assertEquals(products.get(1).getId(),userOrder.getProducts().get(1).getId());
        Assertions.assertEquals(products.get(2).getId(),userOrder.getProducts().get(2).getId());

        Assertions.assertEquals(products.get(0).getWeight(),userOrder.getProducts().get(0).getWeight());
        Assertions.assertEquals(products.get(1).getWeight(),userOrder.getProducts().get(1).getWeight());
        Assertions.assertEquals(products.get(2).getWeight(),userOrder.getProducts().get(2).getWeight());

        Assertions.assertEquals(products.get(0).getPrice(),userOrder.getProducts().get(0).getPrice());
        Assertions.assertEquals(products.get(1).getPrice(),userOrder.getProducts().get(1).getPrice());
        Assertions.assertEquals(products.get(2).getPrice(),userOrder.getProducts().get(2).getPrice());

    }

    @Test
    void setProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"aaa",23.4,23.4,123));
        products.add(new Product(2,"bb",23.4,23.4,123));
        products.add(new Product(3,"cc",23.4,23.4,123));
        UserOrder userOrder = new UserOrder(1,null,products,23);
        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(1,"aaa",34,12.3,1));
        products2.add(new Product(2,"bb",12,66,2));
        products2.add(new Product(3,"cc",67,37,3));

        userOrder.setProducts(products2);

        Assertions.assertEquals(products2.get(0).getId(),userOrder.getProducts().get(0).getId());
        Assertions.assertEquals(products2.get(1).getId(),userOrder.getProducts().get(1).getId());
        Assertions.assertEquals(products2.get(2).getId(),userOrder.getProducts().get(2).getId());

        Assertions.assertEquals(products2.get(0).getWeight(),userOrder.getProducts().get(0).getWeight());
        Assertions.assertEquals(products2.get(1).getWeight(),userOrder.getProducts().get(1).getWeight());
        Assertions.assertEquals(products2.get(2).getWeight(),userOrder.getProducts().get(2).getWeight());

        Assertions.assertEquals(products2.get(0).getPrice(),userOrder.getProducts().get(0).getPrice());
        Assertions.assertEquals(products2.get(1).getPrice(),userOrder.getProducts().get(1).getPrice());
        Assertions.assertEquals(products2.get(2).getPrice(),userOrder.getProducts().get(2).getPrice());
    }

    @Test
    void getDeliveryRunId() {
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        long expected = 23;
        Assertions.assertEquals(23,userOrder.getDeliveryRunId());
    }

    @Test
    void setDeliveryRunId() {
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        long expected = 12;
        userOrder.setDeliveryRunId(12);
        Assertions.assertEquals(expected,userOrder.getDeliveryRunId());
    }

    @Test
    void getPharmacy() {
        Pharmacy pharmacy = new Pharmacy(2,new Address("a",0,0));
        UserOrder userOrder = new UserOrder(1,null,pharmacy,new LinkedList<>(),23);
        long expected = 2;
        Assertions.assertEquals(expected,userOrder.getPharmacy().getId());
    }

    @Test
    void setPharmacy() {
        Pharmacy pharmacy = new Pharmacy(2,new Address("a",0,0));
        Pharmacy pharmacyExpected = new Pharmacy(3,new Address("a",0,0));
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        userOrder.setPharmacy(pharmacyExpected);
        Assertions.assertEquals(pharmacyExpected.getId(),userOrder.getPharmacy().getId());
    }

    @Test
    void setTotalWeight() {
        Pharmacy pharmacy = new Pharmacy(2,new Address("a",0,0));
        Pharmacy pharmacyExpected = new Pharmacy(3,new Address("a",0,0));
        UserOrder userOrder = new UserOrder(1,null,new LinkedList<>(),23);
        userOrder.setTotalWieght(155);
        Assertions.assertEquals(155,userOrder.getTotalWieght());
    }
}