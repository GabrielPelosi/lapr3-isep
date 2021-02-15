package lapr.project.data;

import lapr.project.model.Park;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Park db.
 */
public class ParkDB extends DataHandler{

    private static final long SCOOTER_PARK_TYPE_ID = 1;
    private static final long DRONE_PARK_TYPE_ID = 2;

    /**
     * Add scooter park boolean.
     *
     * @param park the park
     * @return the boolean
     */
    public boolean addScooterPark(Park park){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call add_park(?,?,?,?) }")) {

            callStmt.setLong(1, park.getnCharginsSlot());
            callStmt.setLong(2,park.getnParkingsSlot());
            callStmt.setLong(3,SCOOTER_PARK_TYPE_ID);
            callStmt.setLong(4,park.getPharmacy().getId());

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
     * Add drone park boolean.
     *
     * @param park the park
     * @return the boolean
     */
    public boolean addDronePark(Park park){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call add_park(?,?,?,?) }")) {

            callStmt.setLong(1, park.getnCharginsSlot());
            callStmt.setLong(2,park.getnParkingsSlot());
            callStmt.setLong(3,DRONE_PARK_TYPE_ID);
            callStmt.setLong(4,park.getPharmacy().getId());

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
     * Remove park by id boolean.
     *
     * @param idPark the id park
     * @return the boolean
     */
    public boolean removeParkById(long idPark) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ call remove_park_by_id(?) }")) {

            callStmt.setLong(1, idPark);

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
     * Is park exists by id boolean.
     *
     * @param idPark the id park
     * @return the boolean
     */
    public boolean isParkExistsById(long idPark) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call is_park_exists_by_id(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, idPark);

            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (!rSet.isBeforeFirst()) {
                closeAll();
                return false;
            }else {
                closeAll();
                return true;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Gets last park created.
     *
     * @return the last park created
     */
    public long getLastParkCreated() {
        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_park_created() }")) {
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
}
