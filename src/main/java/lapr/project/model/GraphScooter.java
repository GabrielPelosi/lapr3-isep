package lapr.project.model;


import lapr.project.data.AddressDB;
import lapr.project.data.LocalDB;


import lapr.project.utils.PhysicsCalculations.Distance;
import lapr.project.utils.PhysicsCalculations.Energy;
import lapr.project.utils.graphmap.Graph;


import java.util.*;


/**
 * The type Graph scooter.
 */
public class GraphScooter extends Graph<Address, Integer> {

    private final String DISTANCE = "DISTANCE";
    private final String ENERGY = "ENERGY";
    private final String weight;

    /**
     * Instantiates a new Graph scooter.
     *
     * @param weight the weight
     */
    public GraphScooter(String weight) {
        super(true);
        this.weight = weight;
        preencherGrafo();
    }

    /**
     * Preencher grafo.
     */
    public void preencherGrafo() {

        preencherVertices();
        preencherEdges();
    }

    /**
     * Preencher vertices.
     */
    public void preencherVertices() {
        AddressDB db = new AddressDB();
        List<Address> l = db.getAllAddresses();
        for (Address a : l)
            insertVertex(a);
    }


    /**
     * Preencher edges.
     */
    public void preencherEdges() {
        LocalDB db = new LocalDB();
        List<Local[]> l = db.getAllLocationsWithConnections();
        List<Address> addressesInALocation;
        List<Address> addressesInAnotherLocation;
        for (Local[] o : l) {
            addressesInALocation = db.getAddressByLocation(o[0]);
            addressesInAnotherLocation = db.getAddressByLocation(o[1]);
            inserirEdges(addressesInALocation, addressesInAnotherLocation);
        }
    }

    /**
     * Inserir edges boolean.
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     */
    public boolean inserirEdges(List<Address> a, List<Address> b) {
        LinkedList<Address> primeiras = new LinkedList<>(a);

        Address primeiroAddress = primeiras.getFirst();
        primeiras.removeFirst();

        switch (weight) {
            case DISTANCE:
                insertDistance(primeiroAddress, b);
                break;
            case ENERGY:
                insertEnergy(primeiroAddress, b);
                break;
            default:
                return false;
        }
        return primeiras.size() <= 1 || inserirEdges(primeiras, b);
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
