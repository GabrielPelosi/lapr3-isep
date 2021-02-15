package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class CourierServiceTest {


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
    void createNewInvalidCourier() {
        //Email already registered
        CourierService courierService = new CourierService();
        Address address = new Address("a",0,0);
        PHUser phUser = new PHUser(0,1,address,"jaoaDias","123333","joaoa3456@gmail.com");
        Pharmacy pharmacy = new Pharmacy(1,new Address("a",0,0));
        Courier courier = new Courier(0,phUser,pharmacy);
        boolean expected = false;

        Assertions.assertEquals(expected, courierService.createNewCourier("julia","julia@gmail.com","123",pharmacy));
    }

/*    @Test
    void createNewCourier() {

        CourierService courierService = new CourierService();
        Address address = new Address(1,"aa",0,0);
        PHUser phUser = new PHUser(0,1,address,"gggg","434","gabriel@gmail.com");
        Pharmacy pharmacy = new Pharmacy(1,new Address(2,null,0,0));
        Courier courier = new Courier(0,phUser,pharmacy);
        boolean expected = true;

        Assertions.assertEquals(expected, courierService.createNewCourier("gabriel","gabriel@gmail.com","123",pharmacy));
    }*/

/*    @Test
    void removeCourierByEmail() {
        //remove the created courier
        CourierService courierService = new CourierService();
        boolean expected = true;
        Assertions.assertEquals(expected, courierService.removeCourierByEmail("gabriel@gmail.com"));
    }*/



}