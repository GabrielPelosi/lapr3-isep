package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalTest {

    private Local loc1 = new Local("x","x");


    private Local loc1Copia = new Local(loc1);


    @Test
    void ToStringTest(){


        String expected = "Local{local='x'}";
        String result = loc1.toString();

        Assertions.assertEquals(expected,result);
    }

}
