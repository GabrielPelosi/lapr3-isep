package lapr.project.utils.graphmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Vertex.
 *
 * @param <V> the type parameter
 * @param <E> the type parameter
 */
public class Vertex<V,E> {

    private int key ;                     //Vertex key number
    private V  element ;                 //Vertex information
    private Map<V, Edge<V,E>> outVerts; //adjacent vertices

    /**
     * Instantiates a new Vertex.
     */
    public Vertex () {
        key = -1; element = null; outVerts = new LinkedHashMap<>();}

    /**
     * Instantiates a new Vertex.
     *
     * @param k    the k
     * @param vInf the v inf
     */
    public Vertex (int k, V vInf) {
        key = k; element = vInf; outVerts = new LinkedHashMap<>(); }

    /**
     * Instantiates a new Vertex.
     *
     * @param v the v
     */
    public Vertex (Vertex<V,E> v) {
        key = v.getKey(); element = v.getElement();
        outVerts = new LinkedHashMap<>();
        for (V vert : v.outVerts.keySet()){
            Edge<V,E> edge = v.outVerts.get(vert);
            outVerts.put(vert, edge);
        }
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public int getKey() { return key; }

    /**
     * Sets key.
     *
     * @param k the k
     */
    public void setKey(int k) { key = k; }

    /**
     * Gets element.
     *
     * @return the element
     */
    public V getElement() { return element; }

    /**
     * Sets element.
     *
     * @param vInf the v inf
     */
    public void setElement(V vInf) { element = vInf; }

    /**
     * Add adj vert.
     *
     * @param vAdj the v adj
     * @param edge the edge
     */
    public void addAdjVert(V vAdj, Edge<V,E> edge){ outVerts.put(vAdj, edge); }

    /**
     * Get adj vert v.
     *
     * @param edge the edge
     * @return the v
     */
    public V getAdjVert(Edge<V,E> edge){

        for (V vert : outVerts.keySet())
            if (edge.equals(outVerts.get(vert)))
                return vert;

        return null;
    }

    /**
     * Rem adj vert.
     *
     * @param vAdj the v adj
     */
    public void remAdjVert(V vAdj){ outVerts.remove(vAdj); }

    /**
     * Get edge edge.
     *
     * @param vAdj the v adj
     * @return the edge
     */
    public Edge<V,E> getEdge(V vAdj){ return outVerts.get(vAdj); }

    /**
     * Num adj verts int.
     *
     * @return the int
     */
    public int numAdjVerts() { return outVerts.size();}

    /**
     * Gets all adj verts.
     *
     * @return the all adj verts
     */
    public Iterable<V> getAllAdjVerts() {  return outVerts.keySet(); }

    /**
     * Gets all out edges.
     *
     * @return the all out edges
     */
    public Iterable<Edge<V,E>> getAllOutEdges() {  return outVerts.values(); }

    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj){
            return true;
        }

        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;

        Vertex<V,E> otherVertex = (Vertex<V,E>) otherObj;

        if (this.key != otherVertex.key)
            return false;

        if (this.element != null && otherVertex.element != null &&
                !this.element.equals(otherVertex.element))
            return false;

        //adjacency vertices should be equal
        if (this.numAdjVerts() != otherVertex.numAdjVerts())
            return false;

        //and edges also
        Iterator<Edge<V,E>> it1 = this.getAllOutEdges().iterator();
        while (it1.hasNext()){
            Iterator<Edge<V,E>> it2 = otherVertex.getAllOutEdges().iterator();
            boolean exists=false;
            while (it2.hasNext()){
                if (it1.next().equals(it2.next()))
                    exists=true;
            }
            if (!exists)
                return false;
        }
        return true;
    }

    @Override
    public Vertex<V,E> clone() {

        Vertex<V,E> newVertex = new Vertex<>();

        newVertex.setKey(key);
        newVertex.setElement(element);

        for (V vert : outVerts.keySet())
            newVertex.addAdjVert(vert, this.getEdge(vert));

        return newVertex;
    }

    @Override
    public String toString() {
        String st="";
        if (element != null)
            st= element + " (" + key + "): \n";
        if (!outVerts.isEmpty())
            for (V vert : outVerts.keySet())
                st += outVerts.get(vert);

        return st;
    }
}
