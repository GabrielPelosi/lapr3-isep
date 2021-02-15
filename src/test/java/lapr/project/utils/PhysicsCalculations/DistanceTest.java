package lapr.project.utils.PhysicsCalculations;

import lapr.project.data.AddressDB;
import lapr.project.model.Address;
import lapr.project.model.PHUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class DistanceTest {
    Address ADD1 = new Address("x",  34.6131500f, 58.3772300f);
    PHUser user1 = new PHUser(22, 1, ADD1, "xrr", "x", "emaiwwl");
    Address ADD2 = new Address("y",  16.70000f, 68.1500000f);
    PHUser user2 = new PHUser(23, 1, ADD2, "xee", "x", "emaileee");

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
    void calculateDistanceBetweenTwoAddress() {
        double latitudeStreet1 =41.14582;
        double longitudeStreet1 = -8.61398;
        double elev1 = 87;

        double latitudeStreet2 = 41.14723;
        double longitudeStreet2 = -8.60657;
        double elev2 = 91;



        double expResult = 838.0;
        double result = Distance.calculateDistanceBetweenTwoAddresses(latitudeStreet1, longitudeStreet1, latitudeStreet2, longitudeStreet2,elev1,elev2);
        Assertions.assertEquals(expResult, result, 0);


    }
}

