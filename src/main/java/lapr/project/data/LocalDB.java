package lapr.project.data;

import lapr.project.model.Address;
import lapr.project.model.Local;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Local db.
 */
public class LocalDB extends DataHandler{

    /**
     * Get all locations with connections list.
     *
     * @return the list
     */
    public List<Local[]> getAllLocationsWithConnections(){
        List<Local[]> l = new LinkedList<>();
        ResultSet rSetAux;
        try(CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fncAllLocationsWithConnections}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            Local[] auxiliarArray = new Local[2];
            while(rSetAux.next()){
                auxiliarArray[0] = new Local(rSetAux.getString(1));
                auxiliarArray[1] = new Local(rSetAux.getString(2));
                l.add(auxiliarArray);
            }
        }catch(SQLException ignored) {
        }finally {
            closeAll();
        }
        closeAll();
        return l;
    }

    /**
     * Gets address by location.
     *
     * @param o the o
     * @return the address by location
     */
    public List<Address> getAddressByLocation(Local o) {
        List<Address> l = new LinkedList<>();
        ResultSet rSetAux;
        try(CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fncAddressByLocation(?)}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.setString(2, o.getLocal());
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while(rSetAux.next()){
                l.add(new Address(rSetAux.getFloat(1), rSetAux.getFloat(2), rSetAux.getFloat(3),
                        rSetAux.getString(4), rSetAux.getFloat(5), rSetAux.getByte(6)));
            }
        }catch(SQLException ignored) {
        }finally {
            closeAll();
        }
        closeAll();
        return l;
    }
}
