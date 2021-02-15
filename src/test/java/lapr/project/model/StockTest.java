package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {

    @Test
    void getId() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        long expected = 1;
        Assertions.assertEquals(expected,stock.getId());
    }

    @Test
    void setId() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        long expected = 40;
        stock.setId(40);
        Assertions.assertEquals(expected,stock.getId());
    }

    @Test
    void getPharmacy() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        Pharmacy expected = new Pharmacy(1,address);

        Assertions.assertEquals(expected.getId(),stock.getPharmacy().getId());
    }

    @Test
    void setPharmacy() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);



        Park park1 = new Park(2,43,50);
        Address address1 = new Address("a",2,2);
        Pharmacy expected = new Pharmacy(23,address1);

        stock.setPharmacy(expected);

        Assertions.assertEquals(expected.getAddress().getLat(),
                stock.getPharmacy().getAddress().getLat());
        Assertions.assertEquals(expected.getAddress().getLon(),
                stock.getPharmacy().getAddress().getLon());

    }

    @Test
    void getProduct() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        Product expected = new Product(1,"aaaa",12.50,0.50,2);
        Assertions.assertEquals(expected.getId(),stock.getProduct().getId());
        Assertions.assertEquals(expected.getDescription(),stock.getProduct().getDescription());
        Assertions.assertEquals(expected.getPrice(),stock.getProduct().getPrice());
        Assertions.assertEquals(expected.getWeight(),stock.getProduct().getWeight());
    }

    @Test
    void setProduct() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        Product expected = new Product(23,"jj",12.50,0.50,2);
        stock.setProduct(expected);
        Assertions.assertEquals(expected.getId(),stock.getProduct().getId());
        Assertions.assertEquals(expected.getDescription(),stock.getProduct().getDescription());
        Assertions.assertEquals(expected.getPrice(),stock.getProduct().getPrice());
        Assertions.assertEquals(expected.getWeight(),stock.getProduct().getWeight());
    }

    @Test
    void getStock() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        int expected = 200;
        Assertions.assertEquals(expected,stock.getStock());
    }

    @Test
    void setStock() {
        Product product = new Product(1,"aaaa",12.50,0.50,2);
        Park park = new Park(1,30,30);
        Address address = new Address("a",0,0);
        Pharmacy pharmacy = new Pharmacy(1,address);
        Stock stock = new Stock(1,pharmacy,product,200);

        int expected = 350;
        stock.setStock(350);
        Assertions.assertEquals(expected,stock.getStock());

    }
}