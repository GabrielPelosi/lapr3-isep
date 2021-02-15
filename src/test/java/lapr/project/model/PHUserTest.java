package lapr.project.model;

import lapr.project.data.PHUserDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PHUserTest {

    private Address ADD1 = new Address("a", 13f, 14f);
    private Address ADD2 = new Address("a",13f, 14f);
    private Address ADD3 = new Address("a",  13f, 14f);
    private PHUser user1 = new PHUser(1, 1, ADD1, "y", "x", "email");
    private PHUser user2 = new PHUser(1, 1, "y", "x", "email");

    private Address ADD4 = new Address("a",  14f, 15f);
    private Address ADD5 = new Address("a", 13f, 14f);
    private Address ADD6 = new Address("a", 18f, 16f);

    @Test
    public void getIdTest() {

        long expected = 1;

        long result = user1.getId();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getIdAddTest() {
        Address expected = ADD1;

        Address result = user1.getIdAdd();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getIdRoleTest() {
        long expected = 1;

        long result = user1.getIdRole();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getEmailTest() {
        String expected = "email";

        String result = user1.getEmail();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getPasswdTest() {
        String expected = "x";

        String result = user1.getPasswd();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getUserNameTest() {
        String expected = "y";

        String result = user1.getUserName();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void setEmailTest() {
        String expected = "email2";

        user1.setEmail(expected);

        Assertions.assertEquals(expected, user1.getEmail());


    }

    @Test
    public void setPasswdTest() {

        String expected = "passwd";

        user1.setPasswd(expected);

        Assertions.assertEquals(expected, user1.getPasswd());

    }

    @Test
    public void setUserNameTest() {

        String expected = "username";

        user1.setUserName(expected);

        Assertions.assertEquals(expected, user1.getUserName());

    }

    @Test
    public void setIdAddTest() {


        Address expected = ADD6;

        user1.setIdAdd(expected);

        Assertions.assertEquals(expected, user1.getIdAdd());
    }

    @Test
    public void setIdTest() {

        long expected = 1111;

        user1.setId(expected);

        Assertions.assertEquals(expected, user1.getId());

    }




}
