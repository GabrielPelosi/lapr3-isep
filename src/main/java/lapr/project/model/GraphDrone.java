package lapr.project.model;

import java.util.LinkedList;
import java.util.List;

import lapr.project.data.AddressDB;
import lapr.project.utils.PhysicsCalculations.Distance;
import lapr.project.utils.PhysicsCalculations.Energy;
import lapr.project.utils.graphmap.Graph;

/**
 * The type Graph drone.
 */
public class GraphDrone extends Graph<Address, Integer> {

    private final String DISTANCE = "DISTANCE";
    private final String ENERGY = "ENERGY";
    private final String weight;

    /**
     * Instantiates a new Graph drone.
     *
     * @param weight the weight
     */
    public GraphDrone(String weight) {
        super(false);
        this.weight = weight;
        preencherGrafo();
    }

    /**
     * Preencher grafo.
     */
    public void preencherGrafo() {
        AddressDB db = new AddressDB();
        List<Address> l = db.getAllAddresses();
        preencherVertices(new LinkedList<>(l));
        preencherEdges(new LinkedList<>(l));

    }

    /**
     * Preencher vertices.
     *
     * @param addresses the addresses
     */
    public void preencherVertices(List<Address> addresses) {
        for(Address a : addresses)
            insertVertex(a);
    }

    private boolean preencherEdges(LinkedList<Address> addresses) {

        Address firstAddress = addresses.getFirst();
        addresses.removeFirst();

        for(Address a : addresses) {
            switch (weight) {
                case DISTANCE:
                    insertDistance(firstAddress, addresses);
                    break;
                case ENERGY:
                    insertEnergy(firstAddress, addresses);
                default:
                    return false;
            }
        }
        return addresses.size() <= 1 || preencherEdges(addresses);
    }

    /**
     * Insert distance.
     *
     * @param a the a
     * @param b the b
     */
    public void insertDistance(Address a, List<Address> b) {

        for (Address ab : b)
            insertEdge(a, ab, 0, Distance.calculateDistanceBetweenTwoAddresses(a, ab));
    }

    /**
     * Insert energy.
     *
     * @param a the a
     * @param b the b
     */
    public void insertEnergy(Address a, List<Address> b){

        for(Address ab : b)
            insertEdge(a, ab, 0, Energy.energyBetweenTwoPointsScooter());
    }

}
