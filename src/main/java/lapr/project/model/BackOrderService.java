package lapr.project.model;

import lapr.project.data.BackOrderDB;

/**
 * The type Back order service.
 */
public class BackOrderService {

    private final BackOrderDB bd = new BackOrderDB();


    /**
     * Instantiates a new Back order service.
     */
    public BackOrderService() {
    }


    /**
     * Add back order boolean.
     *
     * @param bOrder the b order
     * @return the boolean
     */
    public boolean addBackOrder(BackOrder bOrder){

        return bd.addBackOrder(bOrder);
}
}
