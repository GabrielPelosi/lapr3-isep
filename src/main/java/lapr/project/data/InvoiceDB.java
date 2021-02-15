package lapr.project.data;

import lapr.project.model.Invoice;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * The type Invoice db.
 */
public class InvoiceDB extends DataHandler{

    /**
     * Create new invoice of order boolean.
     *
     * @param invoice the invoice
     * @return the boolean
     */
    public boolean createNewInvoiceOfOrder(Invoice invoice){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call add_invoice(?,?) }")) {

            callStmt.setLong(1, invoice.getUserOrder().getId());
            callStmt.setDouble(2, invoice.getTotal());

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
}
