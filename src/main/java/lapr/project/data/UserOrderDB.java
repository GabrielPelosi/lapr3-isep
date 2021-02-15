package lapr.project.data;

import lapr.project.model.Costumer;
import lapr.project.model.Pharmacy;
import lapr.project.model.Product;
import lapr.project.model.UserOrder;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type User order db.
 */
public class UserOrderDB extends DataHandler {


    /**
     * Create product in user order boolean.
     *
     * @param userorderId the userorder id
     * @param id          the id
     * @param quantity    the quantity
     * @return the boolean
     */
    public boolean createProductInUserOrder(long userorderId, long id, int quantity) {

        try (CallableStatement callStmt = getConnection().prepareCall("{ call add_product_in_user_order(?,?,?) }")) {
            callStmt.setLong(1, userorderId);
            callStmt.setLong(2, id);
            callStmt.setLong(3, quantity);

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {

            return false;
        }finally {
            closeAll();
        }
    }

    /**
     * Create user order boolean.
     *
     * @param userOrder the user order
     * @return the boolean
     */
    public boolean createUserOrder(UserOrder userOrder) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call create_user_order(?,?,?) }")) {
            callStmt.setLong(1, userOrder.getCostumer().getId());
            callStmt.setLong(2, userOrder.getPharmacy().getId());
            callStmt.setDouble(3, userOrder.getTotalWieght());

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll();
        }
    }


    /**
     * Update delivery user boolean.
     *
     * @param id_userorder the id userorder
     * @param id_delivery  the id delivery
     * @return the boolean
     */
    public boolean updateDeliveryUser(long id_userorder, long id_delivery) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call UPDATE_ID_DELIVERY_USEROREDER(?,?) }")) {
            callStmt.setLong(1, id_userorder);
            callStmt.setLong(2, id_delivery);

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll();
        }
    }

    /**
     * Gets user delivery null.
     *
     * @return the user delivery null
     */
    public long getUserDeliveryNull() {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_userorder_created() }")) {
        callStmt.registerOutParameter(1, OracleTypes.CURSOR);
        callStmt.execute();
        ResultSet rSet = (ResultSet) callStmt.getObject(1);

        if (rSet.next()) {
            return rSet.getLong(1);
        } else {
            closeAll();
            return 0;
        }
    } catch (SQLException e) {
        return 0;
    } finally {
        closeAll();
    }
    }

    /**
     * Gets last user o rder created.
     *
     * @return the last user o rder created
     */
    public long getLastUserORderCreatedNull() {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_userorder_created() }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getLong(1);
            } else {
                closeAll();
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll();
        }
    }
}
