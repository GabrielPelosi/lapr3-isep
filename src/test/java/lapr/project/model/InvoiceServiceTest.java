package lapr.project.model;

import lapr.project.controller.CreateNewUserOrderController;
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

import static org.junit.jupiter.api.Assertions.*;

class InvoiceServiceTest {


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
    void createNewInvalidInvoiceUnique() {
        InvoiceService invoiceService= new InvoiceService();
        Invoice invoice = new Invoice(0,new UserOrder(1,null,new LinkedList<>(),1),1200);
        Assertions.assertFalse(invoiceService.createNewInvoice(41,303));
    }

    @Test
    void createNewInvalidInvoice() {
        InvoiceService invoiceService= new InvoiceService();
        Invoice invoice = new Invoice(0,new UserOrder(32323232,null,new LinkedList<>(),1),1200);
        Assertions.assertFalse(invoiceService.createNewInvoice(32323232,12));
    }


    @Test
    void createNewInvoice() {
        //crea user order test to create invocies
        Costumer costumer = new Costumer(1,null,0,9009);
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));

        UserOrderService userOrderService = new UserOrderService();
        System.out.println(userOrderService.createNewUserOrder(costumer,pharmacy,12));
        long idU = userOrderService.getLastUserOrderCreated();
        System.out.println(idU);

        InvoiceService invoiceService= new InvoiceService();

        Assertions.assertTrue(invoiceService.createNewInvoice(idU,40));
    }
}