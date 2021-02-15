package lapr.project.data;

import lapr.project.model.Costumer;
import lapr.project.model.PHUser;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Costumer db.
 */
public class CostumerDB extends DataHandler {

    private static final int MIN_CREDITS = 10;

    /*
    public Costumer getCostumer(long id) {


        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call getCostumer(?) }")) {


            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função .
            callStmt.setLong(2, id);

            // Executa a invocação da função .
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long cId = rSet.getLong(1);
                long uId = rSet.getLong(2);
                long cred = rSet.getLong(3);
                long nif = rSet.getLong(4);

                return new Costumer(cId,new PHUserDB().getPHUser(uId),cred,nif);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Costumer with ID:" + id);
    }

     */


    /**
     * Add costumer boolean.
     *
     * @param cost the cost
     * @return the boolean
     */
    public boolean addCostumer(Costumer cost) {

        try( CallableStatement callStmt = getConnection().prepareCall("{ call addCostumer(?,?,?) }")) {

            callStmt.setLong(1, cost.getIdUser().getId());
            callStmt.setLong(2, cost.getCred());
            callStmt.setLong(3, cost.getNif());

            callStmt.execute();

            closeAll();
            return true;
        } catch (SQLException e) {
            System.out.println("fail to add the user, verify your data, email may be already registered");
        } finally {
            closeAll();
        }
        return false;
    }


    /**
     * Remove costumer.
     *
     * @param cId the c id
     */
    public void removeCostumer(long cId) {

        try( CallableStatement callStmt = getConnection().prepareCall("{ call removeCostumer(?) }")) {

            callStmt.setLong(1, cId);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets highest id.
     *
     * @return the highest id
     */
    public long getHighestId() {


        try( CallableStatement callStmt = getConnection().prepareCall("{ ? = call getHighestCostumerID() }")) {


            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getLong(1);

            }
        } catch (SQLException e) {

        }finally {
            closeAll();
        }
        throw new RuntimeException("Something went wrong, please try again latter.");
    }

    /**
     * Update credtis of costumer by id boolean.
     *
     * @param costumerId the costumer id
     * @param v          the v
     * @return the boolean
     */
    public boolean updateCredtisOfCostumerById(long costumerId, double v) {
        try( CallableStatement callStmt = getConnection().prepareCall("{ call update_credit_by_id(?,?) }")) {



            callStmt.setLong(1, costumerId);
            callStmt.setDouble(2, v);

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
     * Is costumer exists boolean.
     *
     * @param costumerId the costumer id
     * @return the boolean
     */
    public boolean isCostumerExists(long costumerId) {
        try( CallableStatement callStmt = getConnection().prepareCall("{ ? = call is_costumer_exists(?) }")) {


            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, costumerId);

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
            return false;
        }finally {
            closeAll();
        }
    }

    /**
     * Has enough credits boolean.
     *
     * @param costumerId the costumer id
     * @return the boolean
     */
    public boolean hasEnoughCredits(long costumerId) {
        try( CallableStatement callStmt = getConnection().prepareCall("{ ? = call has_enough_credits_by_id(?) }")) {


            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, costumerId);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                boolean res = rSet.getLong(1) > MIN_CREDITS;
                closeAll();
                return res;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeAll();
        }
    }

    /**
     * Pay delivery tax with credits boolean.
     *
     * @param costumerId the costumer id
     * @return the boolean
     */
    public boolean payDeliveryTaxWithCredits(long costumerId) {
        try( CallableStatement callStmt = getConnection().prepareCall("{ call pay_with_credits(?) }")) {

            callStmt.setLong(1, costumerId);


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
     * Create new costumer boolean.
     *
     * @param costumer     the costumer
     * @param lastPhuserId the last phuser id
     * @return the boolean
     */
    public boolean createNewCostumer(Costumer costumer, long lastPhuserId) {
        try( CallableStatement callStmt = getConnection().prepareCall("{ call add_costumer(?,?,?,?,?) }")) {

            callStmt.setLong(1, costumer.getIdUser().getId());
            callStmt.setFloat(2, costumer.getAddress().getLat());
            callStmt.setFloat(3, costumer.getAddress().getLon());
            callStmt.setLong(4, costumer.getCred());
            callStmt.setLong(5, costumer.getNif());


            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            closeAll();
        }
    }
}
