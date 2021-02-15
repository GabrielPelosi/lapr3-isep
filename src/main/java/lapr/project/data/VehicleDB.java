package lapr.project.data;

import lapr.project.model.Address;
import lapr.project.model.Vehicle;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Vehicle db.
 */
public class VehicleDB extends DataHandler {


    /**
     * Create drone boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    public boolean createDrone(Vehicle vehicle) {

        try (CallableStatement callStmt = getConnection().prepareCall("{ call add_drone(?,?,?,?,?,?) }")) {

            callStmt.setLong(1, vehicle.getPharmacy().getId());
            callStmt.setDouble(2, vehicle.getMax_battery());
            callStmt.setDouble(3, vehicle.getActual_battery());
            callStmt.setDouble(4, vehicle.getAerodinamic());
            callStmt.setDouble(5, vehicle.getFrontarea());
            callStmt.setDouble(6, vehicle.getWeight());

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
     * Remove drone boolean.
     *
     * @param droneId the drone id
     * @return the boolean
     */
    public boolean removeDrone(long droneId) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call remove_Drone(?) }")) {


            callStmt.setLong(1, droneId);

            callStmt.execute();


            return true;
        } catch (SQLException ex) {
                ex.printStackTrace();
            return false;
        }
    }


    /**
     * Add a new Scooter model to Scooters table
     *
     * @param vehicle the vehicle
     * @return true if the scooter has been added to the databse, false if its not
     */
    public boolean createScooter(Vehicle vehicle) {

        try (CallableStatement callStmt = getConnection().prepareCall("{ call add_scooter(?,?,?,?,?,?) }")) {

            callStmt.setLong(1, vehicle.getPharmacy().getId());
            callStmt.setDouble(2, vehicle.getMax_battery());
            callStmt.setDouble(3, vehicle.getActual_battery());
            callStmt.setDouble(4, vehicle.getAerodinamic());
            callStmt.setDouble(5, vehicle.getFrontarea());
            callStmt.setDouble(6, vehicle.getWeight());

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

    /**
     * Remove scooter boolean.
     *
     * @param scooterid the scooterid
     * @return the boolean
     */
    public boolean removeScooter(long scooterid) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call remove_scooter(?) }")) {

            callStmt.setLong(1, scooterid);

            callStmt.execute();


            return true;
        } catch (SQLException ex) {

            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Gets drone.
     *
     * @return the drone
     */
    public long getlastDrone() {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call GET_LAST_DRONE_CREATED() }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getLong(1);
            } else {
                closeAll();
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll();
        }
    }

    /**
     * Gets scooter.
     *
     * @return the scooter
     */
    public long getlastScooter() {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_scooter_created() }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getLong(1);
            } else {
                closeAll();
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll();
        }
    }

    /**
     * Is vehicle exists by id boolean.
     *
     * @param vehicleID the vehicle id
     * @return the boolean
     */
    public boolean isVehicleExistsById(long vehicleID) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call is_vehicle_exists_by_id(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, vehicleID);

            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (!rSet.isBeforeFirst()) {
                System.out.println("1 " + rSet);
                closeAll();
                return false;
            } else {
                System.out.println("2 " + rSet);
                closeAll();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    public boolean isVehicleScooter(long vehicleID) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call fnc_is_vehicle_scooter(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, vehicleID);

            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            return rSet.next();

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean isVehicleDrone(long vehicleID) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call fnc_is_vehicle_drone(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, vehicleID);

            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            return rSet.next();

        } catch (SQLException e) {
            return false;
        }
    }

    public List<Vehicle> getScootersWithSufficientEnergy(int energy) {
        List<Vehicle> l = new LinkedList<>();
        ResultSet rSetAux;
        try (CallableStatement callStmtAux = getConnection().prepareCall("{ ? = call fnc_scooters_with_sufficient_energy(?)}");) {
            callStmtAux.registerOutParameter(1, OracleTypes.CURSOR);
            callStmtAux.setInt(2, energy);

            callStmtAux.execute();
            rSetAux = (ResultSet) callStmtAux.getObject(1);
            while (rSetAux.next()) {
                l.add(new Vehicle(rSetAux.getLong(1)));
            }
        } catch (SQLException ignored) {
        }
        return l;
    }
}


