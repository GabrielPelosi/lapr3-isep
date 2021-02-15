package lapr.project.utils.graphmap;

import lapr.project.model.Address;
import lapr.project.model.Route;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class RouteCalculationTest {

    private Graph<Address, Integer> g = new Graph<>(true);

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
        Address c1 = new Address(1,1);
        Address c2 = new Address(2,2);
        Address c3 = new Address(3,3);
        Address c4 = new Address(4,4);
        Address c5 = new Address(5,5);
        g.insertVertex(c1);
        g.insertVertex(c2);
        g.insertVertex(c3);
        g.insertVertex(c4);
        g.insertVertex(c5);
        g.insertEdge(c1, c2, 0, 1);
        g.insertEdge(c2, c3, 0, 1);
        g.insertEdge(c1, c3, 0, 1);
        g.insertEdge(c3, c4, 0, 1);
        g.insertEdge(c4, c5, 0, 1);
        g.insertEdge(c3, c5, 0, 1);
    }

    /*
    @Test
    void pickPharmacy() {
        Address c1 = new Address(41.15227f,-8.60929f, 104);
        Address c2 = new Address(41.16875f,-8.68995f, 4);
        Address c3 = new Address(41.14582f,-8.61398f, 87);
        List<Address> l = new LinkedList<>();
        l.add(c1);
        l.add(c2);
        l.add(c3);
        Route r = RouteCalculation.pickPharmacy(g,l);
        assertNull(r);
    }

     */

   @Test
    void percursoMaisCurtoIntermedios() {
        Address c1 = new Address(1,1);
        Address c2 = new Address(2,2);
        Address c3 = new Address(3,3);
        Address c4 = new Address(4,4);
        Address c5 = new Address(5,5);
        List<Address> l = new LinkedList<>();
        l.add(c2);
        l.add(c3);
        l.add(c4);
        Route r = RouteCalculation.percursoMaisCurtoIntermedios(g, c1, c5, l);
        assertEquals(r.getInicio(), c1);
        assertEquals(r.getFim(), c5);
        assertEquals(r.getRoute().size(), 3);
    }


    @Test
    void createRoute() {
        Address c1 = new Address(1,1);
        Address c3 = new Address(3,3);
        Address c5 = new Address(5,5);
        LinkedList<Address> l = new LinkedList<>();
        l.add(c1);
        l.add(c3);
        l.add(c5);
        Route r = RouteCalculation.createRoute(g, l);
        assertEquals(r.getInicio(), c1);
        assertEquals(r.getFim(), c5);
        assertEquals(r.getRoute().size(), 2);


    }

    @Test
    void menorEnergiaList() {
        Address c1 = new Address(1,1);
        Address c2 = new Address(2,2);
        Address c3 = new Address(3,3);
        Address c5 = new Address(5,5);
        LinkedList<Address> caminho = new LinkedList<>();
        LinkedList<Address> res  = new LinkedList<>();
        caminho.add(c2);
        int resEnergia = RouteCalculation.menorEnergiaList(g, caminho, res, c1, c5);
        assertEquals(res.size(), 4);
        assertTrue(res.contains(c1));
        assertTrue(res.contains(c2));
        assertTrue(res.contains(c3));
        assertTrue(res.contains(c5));
        assertEquals(resEnergia, 3);
    }

    @Test
    void shortestPath() {
        Address c1 = new Address(1,1);
        Address c2 = new Address(2,2);
        Address c3 = new Address(3,3);
        Address c4 = new Address(4,4);
        LinkedList<Address> l = new LinkedList<>();
        RouteCalculation.shortestPath(g, c1, c2, l);
        assertTrue(l.contains(c1));
        assertTrue(l.contains(c2));
        assertEquals(l.size(), 2);
        l = new LinkedList<>();
        RouteCalculation.shortestPath(g, c1, c3, l);
        assertTrue(l.contains(c1));
        assertTrue(l.contains(c3));
        assertEquals(l.size(), 2);
        l = new LinkedList<>();
        RouteCalculation.shortestPath(g, c1, c4, l);
        assertTrue(l.contains(c1));
        assertTrue(l.contains(c3));
        assertTrue(l.contains(c4));
        assertEquals(l.size(), 3);
    }


    @Test
    void shortestPathLength() {
        Address vOrig = new Address(1,1);
        Address[] vertices = new Address[(int) StreamSupport.stream(g.vertices().spliterator(), false).count()];
        Iterator<Address> it = g.vertices().iterator();
        int i = 0;
        while(it.hasNext()){
            vertices[i] = it.next();
            i++;
        }

        boolean[]visited = new boolean[vertices.length];
        int[] pathKeys = new int[vertices.length];
        double[] dist = new double[vertices.length];
        RouteCalculation.shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        for(boolean b : visited){
            assertTrue(b);
        }
        assertEquals(pathKeys[0], -1);
        assertEquals(pathKeys[1], 0);
        assertEquals(pathKeys[2], 0);
        assertEquals(pathKeys[3], 2);
        assertEquals(pathKeys[4], 2);
        assertEquals(dist[0], 0);
        assertEquals(dist[1], 1);
        assertEquals(dist[2], 1);
        assertEquals(dist[3], 2);
        assertEquals(dist[4], 2);
    }

    @Test
    void todasCombinacoes() {
        Address d1 = new Address(1,1);
        Address d2 = new Address(2,2);
        Address d3 = new Address(3,3);
        List<Address> l = new LinkedList<>();
        l.add(d1);
        l.add(d2);
        l.add(d3);
        LinkedList<LinkedList<Address>> res = new LinkedList<>();
        RouteCalculation.todasCombinacoes(res, l, new LinkedList<>());
        assertTrue(res.contains(l));
        l= new LinkedList<>();
        l.add(d1);
        l.add(d3);
        l.add(d2);
        assertTrue(res.contains(l));
        l = new LinkedList<>();
        l.add(d2);
        l.add(d3);
        l.add(d1);
        assertTrue(res.contains(l));
        l = new LinkedList<>();
        l.add(d2);
        l.add(d1);
        l.add(d3);
        assertTrue(res.contains(l));
        l = new LinkedList<>();
        l.add(d3);
        l.add(d1);
        l.add(d2);
        assertTrue(res.contains(l));
        l = new LinkedList<>();
        l.add(d3);
        l.add(d2);
        l.add(d1);
        assertTrue(res.contains(l));
    }

    @Test
    void combinedWeightOfEdgeList() {
    }
}
