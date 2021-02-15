package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NoticationTest {

    @Test
    void getId() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaaa");
        Assertions.assertEquals(1,notiication.getId());
    }

    @Test
    void setId() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaaa");
        notiication.setId(23);
        Assertions.assertEquals(23,notiication.getId());
    }

    @Test
    void getCostumer() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaaa");

        Assertions.assertEquals(1,notiication.getCostumer().getId());
        Assertions.assertEquals(123,notiication.getCostumer().getCred());
        Assertions.assertEquals(3434,notiication.getCostumer().getNif());
    }

    @Test
    void setCostumer() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaaa");
        notiication.setCostumer(new Costumer(2,null,333,323));
        Assertions.assertEquals(2,notiication.getCostumer().getId());
        Assertions.assertEquals(333,notiication.getCostumer().getCred());
        Assertions.assertEquals(323,notiication.getCostumer().getNif());
    }

    @Test
    void getDescription() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaaa");

        Assertions.assertEquals("aaaa",notiication.getDescription());
    }

    @Test
    void setDescription() {
        Notication notiication = new Notication(1,new Costumer(1,null,123,3434),"aaa");
        notiication.setDescription("Entrega iniciada");
        Assertions.assertEquals("Entrega iniciada",notiication.getDescription());
    }
}