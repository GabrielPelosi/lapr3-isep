package lapr.project.data;

import lapr.project.model.Address;
import lapr.project.model.BackOrder;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * The type Back order db.
 */
public class BackOrderDB extends DataHandler {

    /**
     * Add back order boolean.
     *
     * @param bOrder the b order
     * @return the boolean
     */
    public boolean addBackOrder(BackOrder bOrder) {

        try(CallableStatement callStmt = getConnection().prepareCall("{ call addBackOrder(?,?,?,?) }");) {

            callStmt.setLong(1,bOrder.getAskPharmacy().getId() );
            callStmt.setLong(2, bOrder.getSrcPharmacy().getId());
            callStmt.setLong(3, bOrder.getProduct().getId());
            callStmt.setLong(4, bOrder.getStock());


            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            System.out.println("fail to add the user, verify your data, email may be already registered");
        }finally {
            closeAll();
        }
        return false;
    }
}
