package lapr.project.data;


import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Product db.
 */
public class ProductDB extends DataHandler{


    /**
     * Is exists product in pharmacy boolean.
     *
     * @param id         the id
     * @param pharmacyId the pharmacy id
     * @return the boolean
     */
    public boolean isExistsProductInPharmacy(long id, long pharmacyId){

        try(CallableStatement callStmt = getConnection().prepareCall("{ ? =  call get_product_by_id_and_pharmacy_id(?,?) }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2,id);
            callStmt.setLong(3,pharmacyId);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                closeAll();
                return true;
            }else {
                closeAll();
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Update product by id boolean.
     *
     * @param id          the id
     * @param pharmacyId  the pharmacy id
     * @param newStockQnt the new stock qnt
     * @return the boolean
     */
    public boolean updateProductById(long id, long pharmacyId, long newStockQnt) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call update_stock_product(?,?,?) }")) {
            callStmt.setLong(1,id);
            callStmt.setLong(2,pharmacyId);
            callStmt.setLong(3,newStockQnt);

            callStmt.execute();

            closeAll();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }

    }

    /**
     * Update product after order boolean.
     *
     * @param prodId     the prod id
     * @param pharmacyId the pharmacy id
     * @param quantity   the quantity
     * @return the boolean
     */
    public boolean updateProductAfterOrder(long prodId, long pharmacyId, long quantity) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call update_stock_product_after_order(?,?,?) }")) {
            callStmt.setLong(1,prodId);
            callStmt.setLong(2,pharmacyId);
            callStmt.setLong(3,quantity);

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
     * Gets product stock.
     *
     * @param idProd  the id prod
     * @param pharmID the pharm id
     * @return the product stock
     */
    public long getProductStock(long idProd, long pharmID) {

        try(CallableStatement callStmt = getConnection().prepareCall("{ ? =  call get_stock_product_of_pharmacy_by_ids(?,?) }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2,idProd);
            callStmt.setLong(3,pharmID);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long res = rSet.getLong(1);
                closeAll();
                return res;
            }else {
                closeAll();
                return -1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return -1;
        } finally {
            closeAll();
        }
    }

    /**
     * Gets peso produto.
     *
     * @param idProd the id prod
     * @return the peso produto
     */
    public double getPesoProduto(long idProd) {

        try(CallableStatement callStmt = getConnection().prepareCall("{ ? =  call getProductWeight(?) }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2,idProd);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                double res = rSet.getDouble(1);
                closeAll();
                return res;
            }else {
                closeAll();
                return -1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return -1;
        } finally {
            closeAll();
        }
    }
    }
