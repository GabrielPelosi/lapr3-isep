package lapr.project.controller;

import lapr.project.model.Address;
import lapr.project.model.PharmacyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

class RemovePharmacyControllerTest {

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
    void removePharmacyById() {
        PharmacyService pharmacyService = new PharmacyService();
        RemovePharmacyController controller = new RemovePharmacyController();
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
        Assertions.assertTrue(controller.RemovePharmacyById(id));

    }
}