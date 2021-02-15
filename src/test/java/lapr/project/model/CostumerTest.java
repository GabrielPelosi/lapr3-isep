package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CostumerTest {

    private Address ADD1 = new Address("a",  13f, 14f);
    private Address ADD2 = new Address("a",  13f, 14f);
    private Address ADD3 = new Address("a",  13f, 14f);
    private PHUser user1 = new PHUser(1, 1, ADD1, "y", "x", "email");
    private Costumer costx = new Costumer(1,user1,123456789);

    private Address ADD4 = new Address("a",  14f, 15f);
    private Address ADD5 = new Address("a", 13f, 14f);
    private Address ADD6 = new Address("a",  18f, 16f);


    private Costumer cost = new Costumer(1,user1,100,123456789);



    @Test
    public void getIdTest() {
        long expected = 1;

        long result = cost.getId();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getIdUserTest() {

        PHUser expected = user1;

        PHUser result = cost.getIdUser();

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void getNifTest() {

        long expected = 123456789;

        long result = cost.getNif();

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void getCredTest() {
        long expected = 100;

        long result = cost.getCred();

        Assertions.assertEquals(expected, result);


    }

    @Test
    public void setNifTest() {

        long expected = 999999999;

       cost.setNif(expected);

        Assertions.assertEquals(expected, cost.getNif());

    }

    @Test
    public void getAddress() {
         Address address = new Address("aaa",  18f, 16f);

         Costumer costumer = new Costumer(1,user1,123456789,address);

         Assertions.assertEquals(address.getLat(),costumer.getAddress().getLat());
         Assertions.assertEquals(address.getLon(),costumer.getAddress().getLon());
    }

    @Test
    public void setAddress() {
        Address address = new Address("aab",  18f, 16f);


        Costumer costumer = new Costumer(1,user1,123456789,address);

        Address address2 = new Address("aac",  11f, 10f);

        costumer.setAddress(address2);

        Assertions.assertEquals(address2.getLat(),costumer.getAddress().getLat());
        Assertions.assertEquals(address2.getLon(),costumer.getAddress().getLon());


    }
}
