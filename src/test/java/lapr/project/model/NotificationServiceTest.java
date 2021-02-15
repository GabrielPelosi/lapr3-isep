package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

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
    void createNotificationOfInvalidProduct() {
        NotificationService notificationService = new NotificationService();
        Assertions.assertTrue(notificationService.createNotificationOfInvalidProduct(new Costumer(1,null,0,0),"Notification test"));

    }

    @Test
    void createNotificationOfInvalidProductInvalidCustomer() {
        NotificationService notificationService = new NotificationService();
        Assertions.assertFalse(notificationService.createNotificationOfInvalidProduct(new Costumer(323232,null,0,0),"Notification test"));

    }
}