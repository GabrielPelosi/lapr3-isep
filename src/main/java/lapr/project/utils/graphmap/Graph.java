package lapr.project.utils.graphmap;

import java.util.*;

/**
 * The type Graph.
 *
 * @param <V> the type parameter
 * @param <E> the type parameter
 */
public class Graph<V,E> implements GraphInterface<V,E> {

    private int numVert;
    private int numEdge;
    private final boolean isDirected;
    private final Map<V,Vertex<V,E>> vertices;  //all Vertices of the graph

    /**
     * Instantiates a new Graph.
     *
     * @param directed the directed
     */
// Constructs an empty graph (either undirected or directed)
    public Graph(boolean directed) {
        numVert=0;
        numEdge=0;
        isDirected=directed;
        vertices = new LinkedHashMap<>();
    }

    /**
     * Num vertices int.
     *
     * @return the int
     */
    public int numVertices(){ return numVert; }

    /**
     * Vertices iterable.
     *
     * @return the iterable
     */
    public Iterable<V> vertices() { return vertices.keySet(); }

    /**
     * Valid vertex boolean.
     *
     * @param vert the vert
     * @return the boolean
     */
    public boolean validVertex(V vert) {

        if (vertices.get(vert) == null)
            return false;

        return true;
    }

    /**
     * Gets key.
     *
     * @param vert the vert
     * @return the key
     */
    public int getKey(V vert) { return vertices.get(vert).getKey(); }

    /**
     * Adj vertices iterable.
     *
     * @param vert the vert
     * @return the iterable
     */
    public Iterable<V> adjVertices(V vert){

        if (!validVertex(vert))
            return null;

        Vertex<V,E> vertex = vertices.get(vert);

        return vertex.getAllAdjVerts();
    }


    /**
     * Num edges int.
     *
     * @return the int
     */
    public int numEdges(){ return numEdge; }


    /**
     * Edges iterable.
     *
     * @return the iterable
     */
    public Iterable<Edge<V,E>> edges() {

        ArrayList<Edge<V, E>> listAllEdges = new ArrayList<>();

        for (Vertex<V, E> vertex : this.vertices.values()) {
            Iterable<Edge<V, E>> edges = vertex.getAllOutEdges();
            for (Edge<V, E> edge : edges) {
                listAllEdges.add(edge);
            }
        }

        return listAllEdges;
    }

    /**
     * Get edge edge.
     *
     * @param vOrig the v orig
     * @param vDest the v dest
     * @return the edge
     */
    public Edge<V,E> getEdge(V vOrig, V vDest){

        if (!validVertex(vOrig) || !validVertex(vDest))
            return null;

        Vertex<V,E> vorig = vertices.get(vOrig);

        return vorig.getEdge(vDest);
    }

    /**
     * End vertices v [ ].
     *
     * @param edge the edge
     * @return the v [ ]
     */
    public V[] endVertices(Edge<V,E> edge){

        if (edge == null)
            return null;

        if (!validVertex(edge.getVOrig()) || !validVertex(edge.getVDest()))
            return null;

        Vertex<V,E> vorig = vertices.get(edge.getVOrig());

        if (!edge.equals(vorig.getEdge(edge.getVDest())))
            return null;

        return edge.getEndpoints();
    }

    /**
     * Opposite v.
     *
     * @param vert the vert
     * @param edge the edge
     * @return the v
     */
    public V opposite(V vert, Edge<V,E> edge){

        if (!validVertex(vert))
            return null;

        Vertex<V,E> vertex = vertices.get(vert);

        return vertex.getAdjVert(edge);
    }

    /**
     * Out degree int.
     *
     * @param vert the vert
     * @return the int
     */
    public int outDegree(V vert){

        if (!validVertex(vert))
            return -1;

        Vertex<V,E> vertex = vertices.get(vert);

        return vertex.numAdjVerts();
    }

    /**
     * In degree int.
     *
     * @param vert the vert
     * @return the int
     */
    public int inDegree(V vert){

        if (!validVertex(vert))
            return -1;

        int degree=0;
        for (V otherVert : vertices.keySet())
            if (getEdge(otherVert,vert) != null)
                degree++;

        return degree;
    }

    /**
     * Outgoing edges iterable.
     *
     * @param vert the vert
     * @return the iterable
     */
    public Iterable<Edge<V,E>> outgoingEdges(V vert){

        if (!validVertex(vert)) {
            return null;
        }
        Vertex<V,E> vertex = vertices.get(vert);

        return vertex.getAllOutEdges();
    }

    /**
     * Incoming edges iterable.
     *
     * @param vert the vert
     * @return the iterable
     */
    public Iterable<Edge<V,E>> incomingEdges(V vert){

        ArrayList<Edge<V, E>> incomingEdgesList = new ArrayList<>();
        if (vertices.containsKey(vert)){
            Iterable<Edge<V,E>> allEdges = this.edges();
            for (Edge<V,E> edge : allEdges) {
                if (edge.getVDest().equals(vert)) {
                    incomingEdgesList.add(edge);
                }
            }
        }
        return incomingEdgesList;
    }

    /**
     * Insert vertex boolean.
     *
     * @param vert the vert
     * @return the boolean
     */
    public boolean insertVertex(V vert){

        if (validVertex(vert))
            return false;

        Vertex<V,E> vertex = new Vertex<>(numVert,vert);
        vertices.put(vert,vertex);
        numVert++;

        return true;
    }

    /**
     * Insert edge boolean.
     *
     * @param vOrig   the v orig
     * @param vDest   the v dest
     * @param eInf    the e inf
     * @param eWeight the e weight
     * @return the boolean
     */
    public boolean insertEdge(V vOrig, V vDest, E eInf, double eWeight){

        if (getEdge(vOrig,vDest) != null)
            return false;

        if (!validVertex(vOrig))
            insertVertex(vOrig);

        if (!validVertex(vDest))
            insertVertex(vDest);

        Vertex<V,E> vorig = vertices.get(vOrig);
        Vertex<V,E> vdest = vertices.get(vDest);

        Edge<V,E> newEdge = new Edge<>(eInf,eWeight,vorig,vdest);
        vorig.addAdjVert(vDest,newEdge);
        numEdge++;

        //if graph is not direct insert other edge in the opposite direction
        if (!isDirected)
            // if vDest different vOrig
            if (getEdge(vDest,vOrig) == null){
                Edge<V,E> otherEdge = new Edge<>(eInf,eWeight,vdest,vorig);
                vdest.addAdjVert(vOrig,otherEdge);
                numEdge++;
            }

        return true ;
    }

    /**
     * Remove vertex boolean.
     *
     * @param vert the vert
     * @return the boolean
     */
    public boolean removeVertex(V vert){

        if (!validVertex(vert))
            return false;

        //remove all edges that point to vert
        for (Edge<V,E> edge : incomingEdges(vert)){
            V vadj = edge.getVOrig();
            removeEdge(vadj,vert);
        }

        Vertex<V,E> vertex = vertices.get(vert);

        //update the keys of subsequent vertices in the map
        for (Vertex<V,E> v : vertices.values()){
            int keyVert = v.getKey();
            if ( keyVert > vertex.getKey()){
                keyVert = keyVert-1;
                v.setKey(keyVert);
            }
        }
        //The edges that live from vert are removed with the vertex
        vertices.remove(vert);

        numVert--;

        return true;
    }

    /**
     * Remove edge boolean.
     *
     * @param vOrig the v orig
     * @param vDest the v dest
     * @return the boolean
     */
    public boolean removeEdge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest))
            return false;

        Edge<V,E> edge = getEdge(vOrig,vDest);

        if (edge == null)
            return false;

        Vertex<V,E> vorig = vertices.get(vOrig);

        vorig.remAdjVert(vDest);
        numEdge--;

        //if graph is not direct
        if (!isDirected){
            edge = getEdge(vDest,vOrig);
            if (edge != null){
                Vertex<V,E> vdest = vertices.get(vDest);
                vdest.remAdjVert(vOrig);
                numEdge--;
            }
        }
        return true;
    }

    /**
     * Maior centralidade int.
     *
     * @return the int
     */
    public int maiorCentralidade(){
        Iterable<V> itVertices = vertices();
        int i = 0;
        for (V v : itVertices) {
            if (outDegree(v) > i) i = outDegree(v);
        }

        return i;
    }

    /**
     * Buscar vertive pela centralidade list.
     *
     * @param degree the degree
     * @return the list
     */
    public List<V> buscarVertivePelaCentralidade(int degree){

        List<V> l = new LinkedList<>();
        Iterable<V> itVertices = vertices();

        for (V v : itVertices){
            if(outDegree(v) == degree) l.add(v);
        }

        return l;
    }



    //Returns a clone of the graph
    public Graph<V,E> clone() {

        Graph<V,E> newObject = new Graph<>(this.isDirected);

        //insert all vertices
        for (V vert : vertices.keySet())
            newObject.insertVertex(vert);

        //insert all edges
        for (V vert1 : vertices.keySet())
            for (Edge<V,E> e : this.outgoingEdges(vert1))
                if (e != null){
                    V vert2=this.opposite(vert1,e);
                    newObject.insertEdge(vert1, vert2, e.getElement(), e.getWeight());
                }

        return newObject;
    }


    /**
     * Vertex in a given distance list.
     *
     * @param v the v
     * @param n the n
     * @param l the l
     * @return the list
     */
    public List<V> VertexInAGivenDistance(V v, int n, List<V> l) {
        LinkedList<V> vertex = new LinkedList<>();
        if (l.size() == 0) {
            l.add(v);
        }
        if (n <= 0) return l;
        for (V adj : adjVertices(v)) {
            if (!l.contains(adj)) {
                l.add(adj);
                vertex.add(adj);
            }
        }
        n--;
        for (V ver : vertex) {
            VertexInAGivenDistance(ver, n, l);
        }
        return l;
    }

    public boolean equals(Object otherObj) {

        if (this == otherObj)
            return true;

        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;

        Graph<V,E> otherGraph = (Graph<V,E>) otherObj;

        if (numVert != otherGraph.numVertices() || numEdge != otherGraph.numEdges())
            return false;

        //graph must have same vertices
        boolean eqvertex;
        for (V v1 : this.vertices()){
            eqvertex=false;
            for (V v2 : otherGraph.vertices())
                if (v1.equals(v2))
                    eqvertex=true;

            if (!eqvertex)
                return false;
        }
        return true;
    }

    /**
     * Shortest path double.
     *
     * @param vOrig     the v orig
     * @param vDest     the v dest
     * @param shortPath the short path
     * @return the double
     */
    public double shortestPath(V vOrig, V vDest, LinkedList<V> shortPath) {

        if (!validVertex(vOrig) || validVertex(vDest)) { //If either of the vertices are invalid, return -1
            return -1;
        }

        int numVertices = numVertices();
        Iterator<V> itr = vertices.keySet().iterator();
        List<V> l = new LinkedList<>();
        itr.forEachRemaining(l::add);

        V[] vertices = (V[]) l.toArray();
        boolean[] visited = new boolean[numVertices];
        int[] pathKeys = new int[numVertices];
        double[] dist = new double[numVertices];

        shortestPathLength(vOrig, vertices, visited, pathKeys, dist);

        int destIndex = getKey(vDest);

        if (!visited[destIndex]) { //If we didn't get to destiny
            return -1;
        }

        getPath(vOrig, vDest, vertices, pathKeys, shortPath);

        Collections.reverse(shortPath); //Reverse path

        return dist[destIndex];
    }

    /**
     * Gets path.
     *
     * @param vOrig    the v orig
     * @param vDest    the v dest
     * @param verts    the verts
     * @param pathKeys the path keys
     * @param path     the path
     */
    public void getPath(V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        path.add(vDest);
        if (!vOrig.equals(vDest)) {
            vDest = verts[pathKeys[getKey(vDest)]];
            getPath(vOrig, vDest, verts, pathKeys, path);
        }
    }

    private void shortestPathLength(V vOrig, V[] vertices,
                                    boolean[] visited, int[] pathKeys, double[] dist) {

        for (V vertice : vertices) {
            int index = getKey(vertice);
            pathKeys[index] = -1;
            dist[index] = Double.MAX_VALUE;
            visited[index] = false;
        }

        dist[getKey(vOrig)] = 0;

        while (vOrig != null) {
            int indexVertOrig = getKey(vOrig);
            visited[indexVertOrig] = true;

            for (V adjVertice : adjVertices(vOrig)) {
                Edge edge = getEdge(vOrig, adjVertice);
                int indexVertAdj = getKey(adjVertice);
                if (!visited[indexVertAdj] && dist[indexVertAdj] > dist[indexVertOrig] + edge.getWeight()) {
                    dist[indexVertAdj] = dist[indexVertOrig] + edge.getWeight();
                    pathKeys[indexVertAdj] = indexVertOrig;
                }
            }

            double minDist = Double.MAX_VALUE;

            vOrig = null;

            for (V vertice : vertices) {
                int index = getKey(vertice);
                if (dist[index] < minDist && !visited[index]) {
                    minDist = dist[index];
                    vOrig = vertice;
                }
            }
        }
    }



    //string representation
    @Override
    public String toString() {
        String s="" ;
        if (numVert == 0) {
            s = "\nGraph not defined!!";
        }
        else {
            s = "Graph: "+ numVert + " vertices, " + numEdge + " edges\n";
            for (Vertex<V,E> vert : vertices.values())
                s += vert + "\n" ;
        }
        return s ;
    }

    public List<V> getAllInformation(List<V> path) {
        List<V> l = new LinkedList<>();
        for(V v : vertices()){
            if(path.contains(v)) l.add(v);
        }
        return l;
    }
}
