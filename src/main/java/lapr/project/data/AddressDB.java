package lapr.project.data;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Address;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Address db.
 */
public class AddressDB extends DataHandler{


    /**
     * Get all addresses list.
     *
     * @return the list
     */
    public List<Address> getAllAddresses(){
        List<Address> l = new LinkedList<>();
        ResultSet rSetAux;
        try( CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fncAllAddresses}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
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

    /**
     * Create address boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean createAddress(Address address) {
        try (CallableStatement callStmt= getConnection().prepareCall("{ call addAddress(?,?,?,?) }");){

            callStmt.setFloat(1, address.getLat());
            callStmt.setFloat(2, address.getLon());
            callStmt.setFloat(3, address.getElevation());
            callStmt.setString(4, address.getLocal());

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            closeAll();
        }
    }


    public boolean removeAddressAll(float lati, float longi, long alt, String local ) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call remove_address_by_all(?,?,?,?) }")) {
            System.out.println('2');
            callStmt.setLong(1, (long) lati);
            callStmt.setLong(2, (long) longi);
            callStmt.setLong(3, alt);
            callStmt.setString(4, local);
            System.out.println('4');
            callStmt.execute();
            System.out.println('3');
            closeAll();
            return true;
        } catch (SQLException e) {
            System.out.println('4');
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }
}
