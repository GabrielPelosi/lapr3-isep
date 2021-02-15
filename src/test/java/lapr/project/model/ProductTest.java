package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    


    @Test
    void getId() {
        Product prod = new Product(1,"Voltaren",1.25,0.50,2);
        double expected = 1;
        Assertions.assertEquals(expected,prod.getId());
    }

    @Test
    void setId() {
        Product prod = new Product(1,"Voltaren",1.25,0.50,2);
        double expected = 2;
        prod.setId(2);
        Assertions.assertEquals(expected,prod.getId());
    }

    @Test
    void getDescription() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        String expected = "Voltaren 50 mg";
        Assertions.assertEquals(expected,prod.getDescription());
    }

    @Test
    void setDescription() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        String expected = "Voltaren 100 mg";
        prod.setDescription("Voltaren 100 mg");
        Assertions.assertEquals(expected,prod.getDescription());
    }

    @Test
    void getPrice() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected = 1.25;
        Assertions.assertEquals(expected,prod.getPrice());
    }

    @Test
    void setPrice() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected =2.66;
        prod.setPrice(2.66);
        Assertions.assertEquals(expected,prod.getPrice());
    }

    @Test
    void getWeight() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected =0.50;
        Assertions.assertEquals(expected,prod.getWeight());
    }

    @Test
    void setWeight() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected =2.55;
        prod.setWeight(2.55);
        Assertions.assertEquals(expected,prod.getWeight());
    }

    @Test
    void getQuantity() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected =34;
        prod.setQuantity(34);
        Assertions.assertEquals(expected,prod.getQuantity());
    }

    @Test
    void setQuantity() {
        Product prod = new Product(1,"Voltaren 50 mg",1.25,0.50,2);
        double expected =2;
        Assertions.assertEquals(expected,prod.getQuantity());
    }
}