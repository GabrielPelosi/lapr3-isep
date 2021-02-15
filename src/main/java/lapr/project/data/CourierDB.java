package lapr.project.data;

import lapr.project.model.Address;
import lapr.project.model.Courier;
import lapr.project.model.Pharmacy;
import oracle.jdbc.OracleTypes;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * The type Courier db.
 */
public class CourierDB extends DataHandler{


    /**
     * Create new courier boolean.
     *
     * @param courier the courier
     * @return the boolean
     */
    public boolean createNewCourier(Courier courier){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call add_courier(?,?) }");) {

            callStmt.setLong(1, courier.getPharmacy().getId());
            callStmt.setFloat(2, courier.getPhUser().getId());

            callStmt.execute();

            closeAll();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            closeAll();
        }

    }

    /**
     * Remove courier by email boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean removeCourierByEmail(String s) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call remove_courier_by_email(?) }");) {
            callStmt.setString(1, s);

            callStmt.execute();

            closeAll();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    public List<Courier> getFreeCouriers(){
        List<Courier> l = new LinkedList<>();
        ResultSet rSetAux;
            try( CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fnc_get_free_couriers}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while(rSetAux.next()){
                l.add(new Courier(rSetAux.getLong(1), new Pharmacy(rSetAux.getLong(2))));
            }
        }catch(SQLException ignored) {
        }
        return l;
    }
}
