package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    private Address ADD1 = new Address("a", 13f, 14f);
    private Address ADD2 = new Address("a", 13f, 14f);
    private Address ADD3 = new Address("a", 13f, 14f);
    private PHUser user1 = new PHUser(1, 1, ADD1, "x", "x", "email");

    private Address ADD4 = new Address("a", 14f, 15f);
    private Address ADD5 = new Address("a", 16f, 14f);
    private Address ADD6 = new Address("a", 13f, 16f);
    private Address ADD10 = new Address(13f, 14f, 15f, "x", 10f, (byte) 1);

    private Address ADD11 = new Address(null, 13f, 14f);

    private Address ADD12 = new Address( 13f, 14f,1f);
    private Address ADD13 = null;


    @Test
    void getLatTest() {
        float expected = 13f;

        float result = ADD1.getLat();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getLonTest() {
        float expected = 14f;

        float result = ADD1.getLon();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getWindSpeedTest() {
        float result = ADD10.getWindSpeed();
        float expected = 10f;

        Assertions.assertEquals(expected, result);

    }

    @Test
    void getWindDirection() {
        byte result = ADD10.getWindDirection();
        byte expected = 1;

        Assertions.assertEquals(expected, result);

    }


    @Test
    void mutationGetLocalTest() {
        String result = ADD11.getLocal();
        Assertions.assertEquals(null, result);

        String result2 = ADD10.getLocal();
        Assertions.assertEquals("x", result2);


        String result3 = ADD12.getLocal();
        Assertions.assertEquals("LOCAL_POR_OMISSAO", result3);

    }


    @Test
    void EqualsTest(){

        boolean result = ADD1.equals(ADD13);
        Assertions.assertFalse(result);

        result = ADD1.equals(user1);
        Assertions.assertFalse(result);

        result = ADD1.equals(ADD2);
        Assertions.assertTrue(result);

        result = ADD1.equals(ADD5);
        Assertions.assertFalse(result);

        result = ADD1.equals(ADD6);
        Assertions.assertFalse(result);

    }

}
