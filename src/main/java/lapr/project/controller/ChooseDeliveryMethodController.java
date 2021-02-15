package lapr.project.controller;


import lapr.project.data.PharmacyDB;
import lapr.project.model.*;
import lapr.project.utils.graphmap.RouteCalculation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * The type Choose delivery method controller.
 */
public class ChooseDeliveryMethodController {

    private Delivery del;
    private int method; //distance = 0  energy = 1

    /**
     * Instantiates a new Choose delivery method controller.
     *
     * @param del    the del
     * @param method the method
     */
    public ChooseDeliveryMethodController(Delivery del, int method) {
        this.del = new Delivery(del);
        this.method = method;
    }

    public ChooseDeliveryMethodController() {
    }

    public Route pickShortestRoute(){
        Route land = getLandBasedRoute();
        Route air = getAirBasedRoute();
        //del.setPharmacy -- falta fazer isto + persistir;
        return shortestOfTwoRoutes(land, air);
    }

    /**
     * Gets land based route.
     *
     * @return the land based route
     */

    public Route getLandBasedRoute(){
        List<Product> productList = new LinkedList<>();
        for(UserOrder u : del.getUserOrderList()) productList.addAll(u.getProducts());
        List<Pharmacy> listPharmacies = getPharmaciesWithRequiredProducts(productList);
        return getLandBasedRoute(listPharmacies);
    }

    public Route getLandBasedRoute(List<Pharmacy> l) {
        List<Address> addressList = new LinkedList<>();
        for(UserOrder u : del.getUserOrderList()) addressList.add(u.getCostumer().getAddress());
        switch (method) {
            case 0:
                return RouteCalculation.mostEficientOrigin(new GraphScooter("DISTANCE"), addressList, l);
            case 1:
                return RouteCalculation.mostEficientOrigin(new GraphScooter("ENERGY"), addressList, l);
            default:
                return null;
        }
    }

    private List<Pharmacy> getPharmaciesWithRequiredProducts(List<Product> productList) {
        if(productList.isEmpty()) return new LinkedList<>();

        PharmacyDB db = new PharmacyDB();
        List<List<Pharmacy>> aux = new LinkedList<>();


        for(Product p : productList) aux.add(db.getAllPharmaciesWithRequiredProduct(p.getId(), p.getQuantity()));
        return getCommonPharmacies(aux);
    }

    private List<Pharmacy> getCommonPharmacies(List<List<Pharmacy>> aggregateList) {
        if(aggregateList.isEmpty()) return new LinkedList<>();

        List<Pharmacy> l = new LinkedList<>();
        Iterator<List<Pharmacy>> it = aggregateList.iterator();
        if(it.hasNext()) l.addAll(it.next());
        while(it.hasNext()){
            l.retainAll(it.next());
        }
        return l;
    }


    public Route getAirBasedRoute(){
        List<Product> productList = new LinkedList<>();
        for(UserOrder u : del.getUserOrderList()) productList.addAll(u.getProducts());
        List<Pharmacy> listPharmacies = getPharmaciesWithRequiredProducts(productList);

        return getAirBasedRoute(listPharmacies);
    }

    /**
     * Gets air based route.
     *
     * @return the air based route
     */
    public Route getAirBasedRoute(List<Pharmacy> l) {
        List<Address> addressList = new LinkedList<>();
        for(UserOrder u : del.getUserOrderList()) addressList.add(u.getCostumer().getAddress());
        switch (method){
            case 0:
                return RouteCalculation.mostEficientOrigin(new GraphDrone("DISTANCE"), addressList, l);
            case 1:
                return RouteCalculation.mostEficientOrigin(new GraphDrone("ENERGY"), addressList, l);
            default:
                return null;
        }
    }

    /**
     * Shortest of two routes route.
     *
     * @param r1 the r 1
     * @param r2 the r 2
     * @return the route
     */
    public Route shortestOfTwoRoutes(Route r1, Route r2){
        if(r1.compareTo(r2) > 0) return r1;
        return r2;
    }


}
