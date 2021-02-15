package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import lapr.project.utils.graphmap.Edge;
import lapr.project.utils.graphmap.RouteCalculation;


/**
 * The type Route.
 */
public class Route implements Comparable<Route>{

    /**
     * The Route.
     */
    List<Edge<Address, Integer>> route;
    /**
     * The Inicio.
     */
    Address inicio;
    /**
     * The Fim.
     */
    Address fim;

    /**
     * Instantiates a new Route.
     *
     * @param l      the l
     * @param inicio the inicio
     * @param fim    the fim
     */
    public Route(List<Edge<Address, Integer>> l, Address inicio, Address fim) {
        this.route = new LinkedList<>(l);
        this.inicio = new Address(inicio);
        this.fim = new Address(fim);
    }


    public Route(List<Edge<Address, Integer>> route) {
        LinkedList<Edge<Address, Integer>> aux = new LinkedList<>(route);
        this.inicio = aux.getFirst().getVOrig();
        this.fim = aux.getLast().getVDest();
        this.route = new LinkedList<>(route);
    }

    public Route(Route r) {
        this.route = r.getRoute();
        this.inicio = r.getInicio();
        this.fim = r.getFim();
    }


    /**
     * Gets route.
     *
     * @return the route
     */
    public List<Edge<Address, Integer>> getRoute() {
        return new LinkedList<>(route);
    }

    /**
     * Gets inicio.
     *
     * @return the inicio
     */
    public Address getInicio() {
        return inicio;
    }

    /**
     * Gets fim.
     *
     * @return the fim
     */
    public Address getFim() {
        return fim;
    }

    public List<Address> getMidStations(){
        List<Address> l = new LinkedList<>();
        LinkedList<Edge<Address, Integer>> r = new LinkedList<>(route);
        r.removeFirst();
        for(Edge<Address, Integer> e : r) l.add(e.getVOrig());

        return l;
    }

    /**
     * Get combined weight of list int.
     *
     * @return the int
     */
    public int getCombinedWeightOfList(){
        return RouteCalculation.combinedWeightOfEdgeList(route);
    }

    @Override
    public int compareTo(Route o) {
        int combinedWeightOfThis = RouteCalculation.combinedWeightOfEdgeList(route);
        int combinedWeightOfOther = RouteCalculation.combinedWeightOfEdgeList(o.getRoute());
        return combinedWeightOfThis > combinedWeightOfOther ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route1 = (Route) o;
        return route.equals(route1.route) &&
                inicio.equals(route1.inicio) &&
                fim.equals(route1.fim);
    }

    @Override
    public String toString() {
        return "Route{" +
                "route=" + route +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, inicio, fim);
    }

}
