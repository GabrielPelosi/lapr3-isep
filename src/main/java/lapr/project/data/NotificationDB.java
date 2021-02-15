package lapr.project.data;

import lapr.project.model.Costumer;
import lapr.project.model.Product;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Notification db.
 */
public class NotificationDB extends DataHandler {


    /**
     * Create notification of client boolean.
     *
     * @param costumer the costumer
     * @param desc     the desc
     * @return the boolean
     */
    public boolean createNotificationOfClient(Costumer costumer , String desc){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call create_new_notification(?,?) }")) {

            callStmt.setLong(1, costumer.getId());
            callStmt.setString(2, desc);

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            closeAll();
        }
    }

}
