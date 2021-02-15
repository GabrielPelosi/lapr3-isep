package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;


class InvoiceTest {



    @Test
    void getUserOrder() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);
        UserOrder userOrderExpected = new UserOrder(1,null,new LinkedList<>(),0);

        Assertions.assertEquals(userOrderExpected.getId(),invoice.getUserOrder().getId());
        Assertions.assertEquals(userOrderExpected.getCostumer(),invoice.getUserOrder().getCostumer());
    }

    @Test
    void setUserOrder() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);
        UserOrder userOrderExpected = new UserOrder(1,null,new LinkedList<>(),0);

        invoice.setUserOrder(userOrderExpected);
        Assertions.assertEquals(userOrderExpected.getId(),invoice.getUserOrder().getId());
        Assertions.assertEquals(userOrderExpected.getCostumer(),invoice.getUserOrder().getCostumer());
    }

    @Test
    void getTotal() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);

        double expected = 3030;
        Assertions.assertEquals(expected,invoice.getTotal());
    }

    @Test
    void setTotal() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);

        double expected = 433;
        invoice.setTotal(expected);
        Assertions.assertEquals(expected,invoice.getTotal());
    }

    @Test
    void getId() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);

        double expected = 1;
        Assertions.assertEquals(expected,invoice.getId());
    }

    @Test
    void setId() {
        Invoice invoice = new Invoice(1,new UserOrder(1,null,new LinkedList<>(),0),3030);

        double expected = 2;
        invoice.setId(2);
        Assertions.assertEquals(expected,invoice.getId());
    }
}