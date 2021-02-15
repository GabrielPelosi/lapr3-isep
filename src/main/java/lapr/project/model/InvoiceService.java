package lapr.project.model;

import lapr.project.data.InvoiceDB;

import java.util.LinkedList;

/**
 * The type Invoice service.
 */
public class InvoiceService {

    private final InvoiceDB invoiceDB;

    /**
     * Instantiates a new Invoice service.
     */
    public InvoiceService( ) {
        this.invoiceDB = new InvoiceDB();
    }

    /**
     * Create new invoice boolean.
     *
     * @param userOrderId the user order id
     * @param total       the total
     * @return the boolean
     */
    public boolean createNewInvoice(long userOrderId, double total ){
        return invoiceDB.createNewInvoiceOfOrder(new Invoice(0,new UserOrder(userOrderId,null,new LinkedList<>(),0),total));
    }
}
