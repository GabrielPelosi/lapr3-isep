package lapr.project.data;

import lapr.project.model.Address;
import lapr.project.model.Pharmacy;
import lapr.project.model.Product;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Pharmacy db.
 */
public class PharmacyDB extends DataHandler{

    /**
     * Is product of pharmacy has stock boolean.
     *
     * @param pordId   the pord id
     * @param pharId   the phar id
     * @param quantity the quantity
     * @return the boolean
     */
    public boolean isProductOfPharmacyHasStock(long pordId, long pharId,long quantity){
        try(CallableStatement callStmt = getConnection().prepareCall("{ ? =  call get_stock_product_of_pharmacy_by_ids(?,?) }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2,pordId);
            callStmt.setLong(3,pharId);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long a = rSet.getLong(1);
                closeAll();
                return a < quantity;
            }else {
                closeAll();
                return false;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Add pharmacy boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean addPharmacy(Address address) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call addPharmacy(?,?) }")) {
            callStmt.setFloat(1,address.getLat());
            callStmt.setFloat(2,address.getLon());

            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Get all pharmacies with product list.
     *
     * @param pSrc  the p src
     * @param prod  the prod
     * @param stock the stock
     * @return the list
     */
    public List<Pharmacy> getAllPharmaciesWithProduct(Pharmacy pSrc, Product prod, long stock){
        List<Pharmacy> l = new LinkedList<>();
        ResultSet rSetAux;
        try( CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call getAllPharmaciesWithProduct(?,?,?)}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.setLong(2,pSrc.getId());
            callStmtAux.setLong(3,prod.getId());
            callStmtAux.setLong(4,stock);
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while(rSetAux.next()){
                l.add(new Pharmacy(rSetAux.getLong(1),new Address(rSetAux.getFloat(2), rSetAux.getFloat(3))));
            }
        }catch(SQLException ignored) {
        }finally {
            closeAll();
        }
        closeAll();
        return l;
    }

    public List<Pharmacy> getAllPharmacies(){
        List<Pharmacy> l = new LinkedList<>();
        ResultSet rSetAux;
        try( CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fncAllPharmacies() }");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while(rSetAux.next()){
                l.add(new Pharmacy(rSetAux.getLong(1), new Address(rSetAux.getFloat(2), rSetAux.getFloat(3))));
            }
        }catch(SQLException ignored) {
        }
        return l;
    }

    public boolean removePharmacyById(long pharmId) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call remove_pharmacy(?) }")) {

            callStmt.setLong(1, pharmId);

            callStmt.execute();
            closeAll();
            System.out.println("Farmacia eliminada com sucesso.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    public long getLastPharmacyCreated() {
        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_pharmacy_created() }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long res = rSet.getLong(1);
                closeAll();
                return res;
            }else{
                closeAll();
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll();
        }
    }

    public List<Pharmacy> getAllPharmaciesWithRequiredProduct(long idProduto, int quantity) {
        List<Pharmacy> l = new LinkedList<>();
        ResultSet rSetAux;
        try( CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fnc_getAllPharmaciesWithProduct(?, ?)}");){
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.setLong(2,idProduto);
            callStmtAux.setInt(3, quantity);
            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while(rSetAux.next()){
                l.add(new Pharmacy(rSetAux.getLong(1),new Address(rSetAux.getFloat(2), rSetAux.getFloat(3))));
            }
        }catch(SQLException ignored) {
        }finally {
            closeAll();
        }
        closeAll();
        return l;
    }
}