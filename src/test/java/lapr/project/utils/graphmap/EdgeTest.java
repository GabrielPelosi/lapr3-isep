package lapr.project.utils.graphmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    Edge<String, String> instance = new Edge<>() ;

    public EdgeTest() {
    }

    /**
     * Test of getElement method, of class Edge.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");

        String expResult = null;
        assertEquals(expResult, instance.getElement());

        Edge<String, String> instance1 = new Edge<>("edge1",1.0,null,null);
        expResult = "edge1";
        assertEquals(expResult, instance1.getElement());
    }

    /**
     * Test of setElement method, of class Edge.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");

        String eInf = "edge1";
        instance.setElement(eInf);

        assertEquals("edge1", instance.getElement());
    }

    /**
     * Test of getWeight method, of class Edge.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");

        double expResult = 0.0;
        assertEquals(expResult, instance.getWeight(), 0.0);
    }

    /**
     * Test of setWeight method, of class Edge.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        double ew = 2.0;
        instance.setWeight(ew);

        double expResult = 2.0;
        assertEquals(expResult, instance.getWeight(), 2.0);
    }

    /**
     * Test of getVOrig method, of class Edge.
     */
    @Test
    public void testGetVOrig() {
        System.out.println("getVOrig");

        Object expResult = null;
        assertEquals(expResult, instance.getVOrig());

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
        assertEquals(vertex1.getElement(), otherEdge.getVOrig());
    }

    /**
     * Test of setVOrig method, of class Edge.
     */
    @Test
    public void testSetVOrig() {
        System.out.println("setVOrig");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        assertEquals(vertex1.getElement(), instance.getVOrig());
    }

    /**
     * Test of getVDest method, of class Edge.
     */
    @Test
    public void testGetVDest() {
        System.out.println("getVDest");

        Object expResult = null;
        assertEquals(expResult, instance.getVDest());

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
        assertEquals(vertex1.getElement(), otherEdge.getVDest());
    }

    /**
     * Test of setVDest method, of class Edge.
     */
    @Test
    public void testSetVDest() {
        System.out.println("setVDest");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVDest(vertex1);
        assertEquals(vertex1.getElement(), instance.getVDest());
    }

    /**
     * Test of getEndpoints method, of class Edge.
     */
    @Test
    public void testGetEndpoints() {
        System.out.println("getEndpoints");

        String[] expResult = null;
        String[] result = instance.getEndpoints();
        Assertions.assertArrayEquals(expResult, result);

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        instance.setVDest(vertex1);

        String[] expResult1 = {"Vertex1","Vertex1"};
        Assertions.assertArrayEquals(expResult1, instance.getEndpoints());
    }

    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        assertFalse(instance.equals(null), "should not be equal to null");

        assertTrue(instance.equals(instance), "should be equal to itself");

        assertTrue(instance.equals(instance.clone()), "should be equal to a clone");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);

        assertFalse(instance.equals(otherEdge), "should not be equal to otherEdge");
    }

    /**
     * Test of compareTo method, of class Edge.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);

        int expResult = -1;
        int result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);

        otherEdge.setWeight(0.0);
        expResult = 0;
        result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);

        instance.setWeight(2.0);
        expResult = 1;
        result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);
    }

    /**
     * Test of clone method, of class Edge.
     */
    @Test
    public void testClone() {
        System.out.println("clone");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);

        Edge instClone = otherEdge.clone();

        assertTrue(otherEdge.getElement()==instClone.getElement(), "element should be equal");
        assertTrue(otherEdge.getWeight()==instClone.getWeight(), "weight should be equal");

        String[] expResult = otherEdge.getEndpoints();
        Assertions.assertArrayEquals(expResult, instClone.getEndpoints());
    }

    /**
     * Test of toString method, of class Edge.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        instance.setElement("edge1");
        instance.setWeight(1.0);
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        instance.setVDest(vertex1);

        String expResult = "(edge1) - 1.0 - Vertex1";
        String result = instance.toString().trim();
        assertEquals(expResult, result);

        System.out.println(instance);
    }

}