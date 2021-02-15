package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ProductServiceTest {

    @BeforeEach
    void setUp() {
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
    void updateProductById() {
        ProductService productService = new ProductService();
        boolean expected = true;

        Assertions.assertEquals(expected,productService.updateProductById(1,1,100));
    }

    @Test
    void updateProductById2() {
        ProductService productService = new ProductService();
        boolean expected = true;
        Assertions.assertEquals(expected, productService.updateProductById(2, 1, 100));
    }

    @Test
    void updateProductById3() {
        ProductService productService = new ProductService();
        boolean expected = true;
        Assertions.assertEquals(expected, productService.updateProductById(3, 1, 100));
    }

    @Test
    void updateProductB3yId() {
        ProductService productService = new ProductService();

        boolean expected = false;
        Assertions.assertEquals(expected,productService.updateProductById(232323,2,2));

    }

    @Test
    void updateProductByIdInvalid() {
        ProductService productService = new ProductService();

        boolean expected = false;
        Assertions.assertEquals(expected,productService.updateProductById(3,32323,3));
    }

    @Test
    void updateStockAfterOrder() {
        ProductService productService = new ProductService();
        Assertions.assertTrue(productService.updateStockAfterOrder(1,1,2));
    }

    @Test
    void getProdutoStock(){
        ProductService productService = new ProductService();
        Assertions.assertEquals(100,productService.getProductStock(6,2));
    }

    @Test
    void getPesoProduto(){

        ProductService productService = new ProductService();
        Assertions.assertEquals(0.12,productService.getPesoProduto(1));

    }

    @Test
    void getProdutoStockInvalido(){
        ProductService productService = new ProductService();
        Assertions.assertEquals(-1,productService.getProductStock(7,2));
    }
}