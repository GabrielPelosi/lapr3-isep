package lapr.project.model;

import lapr.project.utils.graphmap.Edge;
import lapr.project.utils.graphmap.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteTest {

    Address add1 = new Address(1f, 1f);
    Address add2 = new Address(2f, 1f);
    Address add3 = new Address(3f, 1f);
    Address add4 = new Address(4f, 1f);
    Address add5 = new Address(5f, 1f);
    Address add6 = new Address(6f, 1f);
    Address add7 = new Address(7f, 1f);

    List<Edge<Address, Integer>> list = new ArrayList<>();
    List<Edge<Address, Integer>> list2 = new ArrayList<>();
    List<Address> list3 = new ArrayList<>();

    Vertex<Address, Integer> v1 = new Vertex<>(1, add1);
    Vertex<Address, Integer> v2 = new Vertex<>(2, add2);
    Vertex<Address, Integer> v3 = new Vertex<>(3, add3);
    Vertex<Address, Integer> v4 = new Vertex<>(4, add4);
    Vertex<Address, Integer> v5 = new Vertex<>(5, add5);
    Vertex<Address, Integer> v6 = new Vertex<>(6, add6);
    Vertex<Address, Integer> v7 = new Vertex<>(7, add7);

    Edge<Address, Integer> e1 = new Edge<>(0, 1, v1, v2);
    Edge<Address, Integer> e2 = new Edge<>(0, 1, v2, v3);
    Edge<Address, Integer> e3 = new Edge<>(0, 1, v3, v4);
    Edge<Address, Integer> e4 = new Edge<>(0, 1, v4, v5);
    Edge<Address, Integer> e5 = new Edge<>(0, 1, v5, v6);
    Edge<Address, Integer> e6 = new Edge<>(0, 1, v6, v7);

    @BeforeEach
    void setUp() {

        list.add(e1);
        list.add(e2);
        list2.add(e1);
        list2.add(e2);
        list2.add(e3);
        list2.add(e4);
        list2.add(e5);
        list2.add(e6);

        list3.add(add2);
        list3.add(add3);
        list3.add(add4);
        list3.add(add5);
        list3.add(add6);

    }

    @Test
    void getRouteTest() {

        Route r = new Route(list, add1, add3);

        Route r2 = new Route(r);

        List<Edge<Address, Integer>> expected = list;

        List<Edge<Address, Integer>> result = r.getRoute();

        Assertions.assertEquals(expected, result);

    }

    @Test
    void getInicioTest() {
        Route r = new Route(list, add1, add3);
        Address expected = add1;
        Address result = r.getInicio();

        Assertions.assertEquals(expected, result);

    }

    @Test
    void getFimTest() {
        Route r = new Route(list, add1, add3);
        Address expected = add3;
        Address result = r.getFim();

        Assertions.assertEquals(expected, result);

    }


    @Test
    void getCombinedWeightOfListTest() {
        Route r = new Route(list, add1, add3);
        int expected = 2;
        int result = r.getCombinedWeightOfList();
        Assertions.assertEquals(expected, result);


    }

    @Test
    void compareTo() {
        Route r = new Route(list, add1, add3);
        Route r2 = new Route(list, add1, add3);
        int expected = 1;
        int result = r.compareTo(r2);
        Assertions.assertEquals(expected, result);
        Route r3 = new Route(list2, add1, add7);
        int expected1 = -1;
        int result1 = r3.compareTo(r);
        Assertions.assertEquals(expected1, result1);
    }


    @Test
    void getMidStationsTest() {
        Route r = new Route(list2, add1, add7);
        List<Address> expected = list3;

        List<Address> result = r.getMidStations();

        Assertions.assertEquals(expected, result);
    }


    @Test
    void toStringTest() {
        Route r = new Route(list2, add1, add7);
        String expected = "Route{route=[      (0) - 1.0 - Address{local=x, lat=2.0, lon=1.0}\n" +
                ",       (0) - 1.0 - Address{local=x, lat=3.0, lon=1.0}\n" +
                ",       (0) - 1.0 - Address{local=x, lat=4.0, lon=1.0}\n" +
                ",       (0) - 1.0 - Address{local=x, lat=5.0, lon=1.0}\n" +
                ",       (0) - 1.0 - Address{local=x, lat=6.0, lon=1.0}\n" +
                ",       (0) - 1.0 - Address{local=x, lat=7.0, lon=1.0}\n" +
                "], inicio=Address{local=x, lat=1.0, lon=1.0}, fim=Address{local=x, lat=7.0, lon=1.0}}";
        String result = r.toString();
        Assertions.assertEquals(expected, result);


    }

    @Test
    void hashCodeTest() {
        Route r = new Route(list2, add1, add7);
        int expected = r.hashCode();

        int result = r.hashCode();

        Assertions.assertEquals(expected, result);
    }



    @Test
    void equalsTest(){
        Route r = new Route(list, add1, add3);
        Route r2 = new Route(list, add1, add3);
        Route r3 = null;
        Route r4 = new Route(list, add1, add4);
        Route r5 = new Route(list, add5, add3);
        Route r6 = new Route(list2, add1, add3);

        boolean result = r.equals(r);

        Assertions.assertTrue(result);

        result = r.equals(r2);

        Assertions.assertTrue(result);

        result = r.equals(r3);

        Assertions.assertFalse(result);

        result = r.equals(r4);

        Assertions.assertFalse(result);

        result = r.equals(r5);

        Assertions.assertFalse(result);

        result = r.equals(r6);

        Assertions.assertFalse(result);

        result = r.equals(add1);

        Assertions.assertFalse(result);
    }
}
