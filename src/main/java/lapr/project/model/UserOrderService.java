package lapr.project.model;

import lapr.project.data.Delivery_RunDB;
import lapr.project.data.UserOrderDB;

import java.util.LinkedList;

/**
 * The type User order service.
 */
public class UserOrderService {

    private final UserOrderDB userOrderDB;
    private final Delivery_RunDB delivery_runDB;


    /**
     * Instantiates a new User order service.
     */
    public UserOrderService() {
        this.userOrderDB = new UserOrderDB();
        this.delivery_runDB=new Delivery_RunDB();
    }

    /**
     * Create new user order boolean.
     *
     * @param costumer   the costumer
     * @param pharmacy   the pharmacy
     * @param totalWieht the total wieht
     * @return the boolean
     */
    public boolean createNewUserOrder(Costumer costumer, Pharmacy pharmacy, double totalWieht) {
        //products are not required in this query
        return userOrderDB.createUserOrder(new UserOrder(0,costumer,pharmacy,new LinkedList<>(),0, totalWieht));
    }

    /**
     * Gets last delivery.
     *
     * @return the last delivery
     */
    public long getLastDelivery() {
        return delivery_runDB.getLastDeliveryCreated();
    }

    /**
     * Add products to created order boolean.
     *
     * @param userorderId the userorder id
     * @param id          the id
     * @param quantity    the quantity
     * @return the boolean
     */
    public boolean addProductsToCreatedOrder(long userorderId, long id, int quantity) {
        return userOrderDB.createProductInUserOrder(userorderId, id,quantity);
    }

    /**
     * Check delivery boolean.
     *
     * @param idUserorder the id userorder
     * @return the boolean
     */
    public boolean checkDelivery(UserOrder idUserorder){
        return delivery_runDB.checkIdDelivery(idUserorder);
    }

    /**
     * Update delivery user boolean.
     *
     * @param id_userorder the id userorder
     * @param id_delivery  the id delivery
     * @return the boolean
     */
    public boolean updateDeliveryUser(long id_userorder,long id_delivery){
        return userOrderDB.updateDeliveryUser(id_userorder,id_delivery);
    }

    /**
     * Gets last user order created.
     *
     * @return the last user order created
     */
    public long getLastUserOrderCreated() {
        return userOrderDB.getLastUserORderCreatedNull();
    }
}
