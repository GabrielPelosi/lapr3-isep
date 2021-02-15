package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AddressServiceTest {



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
    void addAddressTest(){

        /*
    AddressService addServ = new AddressService();
        Address add = new Address(1, "x", 13f, 14f);



    boolean result = addServ.createNewAddress(add);

        Assertions.assertEquals(true, result);

         */

    }

  /*  @Test
    void getHighestID(){

        AddressService addServ = new AddressService();
        for (int i =0; i<10; i++){

            addServ.createNewAddress(new Address(i,"x",1f,1f));


        }



        long expected = 10;



        long result = addServ.getHighestId();

        System.out.println(result);

        Assertions.assertEquals(expected, result);
    }
*/
}
