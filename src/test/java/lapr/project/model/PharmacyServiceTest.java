package lapr.project.model;

import lapr.project.controller.AddPharmacyController;
import lapr.project.controller.RemovePharmacyController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PharmacyServiceTest {

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
    void isProductOfPharmacyHasStockTRue() {
        //verify if stock is less than quantity of order, if true, prod must be deleted of order and client notificated
        PharmacyService pharmacyService = new PharmacyService();
        boolean expected = true;
        Assertions.assertTrue(pharmacyService.isProductOfPharmacyHasStock(1,1,99999));
    }

    @Test
    void isProductOfPharmacyHasStockFalse() {
        //verify if stock is less than quantity of order, if true, prod must be deleted of order and client notificated
        PharmacyService pharmacyService = new PharmacyService();
        Assertions.assertFalse(pharmacyService.isProductOfPharmacyHasStock(1,1,1));
    }

    @Test
    void invalidProductOfPharmacyHasStock() {
        //verify if stock is less than quantity of order, if true, prod must be deleted of order and client notificated
        PharmacyService pharmacyService = new PharmacyService();
        boolean expected = false;
        Assertions.assertEquals(expected,pharmacyService.isProductOfPharmacyHasStock(2323,1,23));
    }

    @Test
    void productOfInvalidPharmacyHasStock() {
        //verify if stock is less than quantity of order, if true, prod must be deleted of order and client notificated
        PharmacyService pharmacyService = new PharmacyService();
        boolean expected = false;
        Assertions.assertEquals(expected,pharmacyService.isProductOfPharmacyHasStock(1,2323,23));
    }

    @Test
    void addPharmacyAddresAlreadyExists() {
        PharmacyService pharmacyService = new PharmacyService();
        Assertions.assertFalse(pharmacyService.addPharmacy(new Address("Trindade",41.15227f,-8.60929f,104)));
    }

    @Test
    void removePharmacyById() {
        PharmacyService pharmacyService = new PharmacyService();
        Random rand = new Random();
        float lati = rand.nextFloat();
        float longi = rand.nextFloat();;
        long alti = 135;
        String local = "Teste"+rand.nextInt();
        AddPharmacyController addPharmacyController = new AddPharmacyController();
        addPharmacyController.addPharmacy(new Address(local,lati,longi,alti));
        long id = pharmacyService.getLastPharmacyCreated();

        System.out.println("Id Pharmacy: "+id+",\n"+"Latitude: "+lati+",\n"
                +"Longitude: "+longi +",\n"+ "Local Name: "+local);
        Assertions.assertTrue(pharmacyService.removePharmacyById(id));

    }
}