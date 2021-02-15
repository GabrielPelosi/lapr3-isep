package lapr.project.utils.graphmap;

import lapr.project.model.Address;
import lapr.project.model.Pharmacy;
import lapr.project.model.Route;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * The type Route calculation.
 */
public abstract class RouteCalculation{

    public static Route mostEficientOrigin(Graph<Address, Integer> g, List<Address> addressList, List<Pharmacy> pharmacyList) {
        List<Route> aux = new LinkedList<>();

        for(Pharmacy p : pharmacyList){
            aux.add(percursoMaisCurtoIntermedios(g, p.getAddress(), p.getAddress(), addressList));
        }

        int i = Integer.MAX_VALUE;
        Route finalRoute = null;
        for(Route r : aux)
            if(r.getCombinedWeightOfList() < i) {
            i = r.getCombinedWeightOfList();
            finalRoute = r;
        }

        return finalRoute;
    }

    /**
     * Percurso mais curto intermedios route.
     *
     * @param graph    the graph
     * @param vOrig    the v orig
     * @param vDest    the v dest
     * @param stations the stations
     * @return the route
     */
    public static Route percursoMaisCurtoIntermedios(Graph<Address, Integer> graph, Address vOrig, Address vDest, List<Address> stations) {
        LinkedList<LinkedList<Address>> caminhos = new LinkedList<>();
        LinkedList<Address> tmp = new LinkedList<>();
        todasCombinacoes(caminhos, stations, tmp);
        int menorEnergia = Integer.MAX_VALUE;
        LinkedList<Address> menorCaminho = new LinkedList<>();
        for (LinkedList<Address> list : caminhos) {
            LinkedList<Address> finalPath = new LinkedList<>();
            int tmpEnergy = menorEnergiaList(graph, list, finalPath, vOrig, vDest);
            if (tmpEnergy < menorEnergia) {
                menorEnergia = tmpEnergy;
                menorCaminho = new LinkedList<>(finalPath);
            }
        }
        return createRoute(graph, menorCaminho);
    }

    /**
     * Create route route.
     *
     * @param graph the graph
     * @param path  the path
     * @return the route
     */
    public static Route createRoute(Graph<Address, Integer> graph, List<Address> path) {
        path = graph.getAllInformation(path);
        List<Edge<Address, Integer>> l = new LinkedList<>();
        ListIterator<Address> it = path.listIterator();
        Address c;
        while(it.hasNext()){
            c = it.next();
            if(it.hasNext()) {
                l.add(graph.getEdge(c, it.next()));
                it.previous();
            }
        }
        return new Route(l);
    }

    /**
     * Menor energia list int.
     *
     * @param graph   the graph
     * @param list    the list
     * @param caminho the caminho
     * @param vOrig   the v orig
     * @param vDest   the v dest
     * @return the int
     */
    public static int menorEnergiaList(Graph<Address, Integer> graph, LinkedList<Address> list, LinkedList<Address> caminho, Address vOrig, Address vDest) {
        ListIterator<Address> atual = list.listIterator();
        LinkedList<Address> tmp = new LinkedList<>();
        Address station = atual.next();
        int energiaAtual = (int) Math.round(shortestPath(graph, vOrig, station, tmp));
        caminho.addAll(tmp);
        if (list.size() == 1) {
            tmp.clear();
            energiaAtual += (int) Math.round(shortestPath(graph, station, vDest, tmp));
            if(!tmp.isEmpty()) {
                tmp.removeFirst();
                caminho.addAll(tmp);
            }
        } else {
            atual.previous();
            while (atual.hasNext()){
                Address stationInicio = atual.next();
                tmp.clear();
                if (atual.hasNext()){
                    Address stationFim = atual.next();
                    atual.previous();
                    energiaAtual += (int) Math.round(shortestPath(graph, stationInicio, stationFim, tmp));
                } else {
                    energiaAtual += (int) Math.round(shortestPath(graph, stationInicio, vDest, tmp));
                    tmp.removeFirst();
                    caminho.addAll(tmp);
                }
            }
        }
        return energiaAtual;
    }

    /**
     * Shortest path double.
     *
     * @param g         the g
     * @param vOrig     the v orig
     * @param vDest     the v dest
     * @param shortPath the short path
     * @return the double
     */
    public static double shortestPath(Graph<Address, Integer> g, Address vOrig, Address vDest, LinkedList<Address> shortPath) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) { //If either of the vertices are invalid, return -1
            return -1;
        }

        int numVertices = g.numVertices();
        Address[] vertices = new Address[(int) StreamSupport.stream(g.vertices().spliterator(), false).count()];
        Iterator<Address> it = g.vertices().iterator();
        int i = 0;
        while(it.hasNext()){
            vertices[i] = it.next();
            i++;
        }
        boolean[] visited = new boolean[numVertices];
        int[] pathKeys = new int[numVertices];
        double[] dist = new double[numVertices];

        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);

        int destIndex = g.getKey(vDest);

        if (!visited[destIndex]) { //If we didn't get to destiny
            return -1;
        }

        getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);

        Collections.reverse(shortPath); //Reverse path

        return dist[destIndex];
    }

    /**
     * Gets path.
     *
     * @param g        the g
     * @param vOrig    the v orig
     * @param vDest    the v dest
     * @param verts    the verts
     * @param pathKeys the path keys
     * @param path     the path
     */
    public static void getPath(Graph<Address, Integer> g, Address vOrig, Address vDest, Address[] verts, int[] pathKeys, LinkedList<Address> path) {

        path.add(vDest);
        if (!vOrig.equals(vDest)) {
            vDest = verts[pathKeys[g.getKey(vDest)]];
            getPath(g, vOrig, vDest, verts, pathKeys, path);
        }
    }


    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights This implementation
     * uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param vertices the vertices
     * @param visited  set of discovered vertices
     * @param pathKeys the path keys
     * @param dist     minimum distances
     */
    public static void shortestPathLength(Graph<Address, Integer> g, Address vOrig, Address[] vertices,
                                           boolean[] visited, int[] pathKeys, double[] dist) {

        for (Address vertice : vertices) {
            int index = g.getKey(vertice);
            pathKeys[index] = -1;
            dist[index] = Double.MAX_VALUE;
            visited[index] = false;
        }
        dist[g.getKey(vOrig)] = 0;

        while (vOrig != null) {
            int indexVertOrig = g.getKey(vOrig);
            visited[indexVertOrig] = true;

            for (Address adjVertice : g.adjVertices(vOrig)) {
                Edge<Address, Integer> edge = g.getEdge(vOrig, adjVertice);
                int indexVertAdj = g.getKey(adjVertice);
                if (!visited[indexVertAdj] && dist[indexVertAdj] > dist[indexVertOrig] + edge.getWeight()) {
                    dist[indexVertAdj] = dist[indexVertOrig] + edge.getWeight();
                    pathKeys[indexVertAdj] = indexVertOrig;
                }
            }

            double minDist = Double.MAX_VALUE;

            vOrig = null;

            for (Address vertice : vertices) {
                int index = g.getKey(vertice);
                if (dist[index] < minDist && !visited[index]) {
                    minDist = dist[index];
                    vOrig = vertice;
                }
            }
        }
    }


    /**
     * Todas combinacoes.
     *
     * @param caminhos  the caminhos
     * @param crossings the crossings
     * @param tmp       the tmp
     */
    public static void todasCombinacoes(LinkedList<LinkedList<Address>> caminhos, List<Address> crossings, LinkedList<Address> tmp) {
        List<Address> tmpStations = new LinkedList<>(crossings);
        if (crossings.isEmpty()) {
            caminhos.add(new LinkedList<>(tmp));
            tmp.removeLast();
        } else {
            for (Address atual : crossings) {
                tmp.add(atual);
                tmpStations.remove(atual);
                todasCombinacoes(caminhos, tmpStations, tmp);
                tmpStations.add(atual);
                tmp.remove(atual);
            }
        }
    }

    /**
     * Combined weight of edge list int.
     *
     * @param l the l
     * @return the int
     */
    public static int combinedWeightOfEdgeList(List<Edge<Address, Integer>> l){
        LinkedList<Edge<Address, Integer>> aux = new LinkedList<>(l);
        int sum = 0;
        for(Edge e : aux)
            sum+= e.getWeight();
        return sum;
    }


}
