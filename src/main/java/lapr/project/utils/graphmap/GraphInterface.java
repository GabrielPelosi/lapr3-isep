package lapr.project.utils.graphmap;

/**
 * The interface Graph interface.
 *
 * @param <V> the type parameter
 * @param <E> the type parameter
 */
public interface GraphInterface<V,E> {

    /**
     * Num vertices int.
     *
     * @return the int
     */
// Returns the number of vertices of the graph
    int numVertices();

    /**
     * Vertices iterable.
     *
     * @return the iterable
     */
// Returns all the vertices of the graph as an iterable collection
    Iterable<V> vertices();

    /**
     * Num edges int.
     *
     * @return the int
     */
// Returns the number of edges of the graph
    int numEdges();

    /**
     * Edges iterable.
     *
     * @return the iterable
     */
// Returns the information of all the edges of the graph as an iterable collection
    Iterable<Edge<V,E>> edges();

    /**
     * Gets edge.
     *
     * @param vOrig the v orig
     * @param vDest the v dest
     * @return the edge
     */
    /* Returns the edge from vorig to vdest, or null if vertices are not adjacent
     * @param vorig
     * @param vdest
     * @return the edge or null if vertices are not adjacent or don't exist
     */
    Edge<V,E> getEdge(V vOrig, V vDest);

    /**
     * End vertices v [ ].
     *
     * @param edge the edge
     * @return the v [ ]
     */
    /* Returns the vertices of edge e as an array of length two
     * If the graph is directed, the first vertex is the origin, and
     * the second is the destination.  If the graph is undirected, the
     * order is arbitrary.
     * @param e
     * @return array of two vertices or null if edge doesn't exist
     */
    V[] endVertices(Edge<V,E> edge);

    /**
     * Opposite v.
     *
     * @param vert the vert
     * @param edge the edge
     * @return the v
     */
    /* Returns the vertex that is opposite vertex v on edge e.
     * @param v
     * @param e
     * @return opposite vertex, or null if vertex or edge don't exist
     */
    V opposite(V vert, Edge<V,E> edge);

    /**
     * Out degree int.
     *
     * @param vert the vert
     * @return the int
     */
    int outDegree(V vert) ;

    /**
     * In degree int.
     *
     * @param vert the vert
     * @return the int
     */
    int inDegree(V vert) ;

    /**
     * Outgoing edges iterable.
     *
     * @param vert the vert
     * @return the iterable
     */
    /* Returns an iterable collection of edges for which vertex v is the origin
     * for an undirected graph, this is the same result returned by incomingEdges
     * @param v
     * @return iterable collection of edges, null if vertex doesn't exist
     */
    Iterable<Edge<V,E>> outgoingEdges (V vert);

    /**
     * Incoming edges iterable.
     *
     * @param vert the vert
     * @return the iterable
     */
    /* Returns an iterable collection of edges for which vertex v is the destination
     * For an undirected graph this is the same result as returned by incomingEdges
     * @param v
     * @return iterable collection of edges reaching vertex, null if vertex doesn't exist
     */
    Iterable<Edge<V,E>> incomingEdges(V vert);

    /**
     * Insert vertex boolean.
     *
     * @param newVert the new vert
     * @return the boolean
     */
    /* Inserts a new vertex with some specific comparable type
     * @param element the vertex contents
     * @return a true if insertion suceeds, false otherwise
     */
    boolean insertVertex(V newVert);

    /**
     * Insert edge boolean.
     *
     * @param vOrig   the v orig
     * @param vDest   the v dest
     * @param edge    the edge
     * @param eWeight the e weight
     * @return the boolean
     */
    /* Adds a new edge between vertices u and v, with some
     * specific comparable type. If vertices u, v don't exist in the graph they
     * are inserted
     * @param vorigInf Information of vertex source
     * @param vdestInf Information of vertex destination
     * @param eInf edge information
     * @param eWeight edge weight
     * @return true if suceeds, or false if an edge already exists between the two verts.
     */
    boolean insertEdge(V vOrig, V vDest, E edge, double eWeight);


    /**
     * Remove vertex boolean.
     *
     * @param vert the vert
     * @return the boolean
     */
    /* Removes a vertex and all its incident edges from the graph
     * @param vInf Information of vertex source
     */
    boolean removeVertex(V vert);

    /**
     * Remove edge boolean.
     *
     * @param vOrig the v orig
     * @param vDest the v dest
     * @return the boolean
     */
    /* Removes the edge between two vertices
     *
     * @param vA Information of vertex source
     * @param vB Information of vertex destination
     */
    boolean removeEdge(V vOrig, V vDest);
}
