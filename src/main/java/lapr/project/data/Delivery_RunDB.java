package lapr.project.data;

import lapr.project.model.Delivery;
import lapr.project.model.UserOrder;
import lapr.project.model.Vehicle;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Delivery run db.
 */
public class Delivery_RunDB extends DataHandler {


    /**
     * Create delivery boolean.
     *
     * @param delivery the delivery
     * @return the boolean
     */

    public boolean createDelivery(Delivery delivery) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call add_delivery(?,?,?,?) }")) {
            //callStmt.setLong(1, scooter.getId());
            callStmt.setLong(1, 1);
            callStmt.setLong(2, delivery.getIdvehicle().getId());
            callStmt.setDouble(3, delivery.getWeight());
            callStmt.setLong(4, delivery.getPharmacy().getId());
            callStmt.execute();

            closeAll();
            System.out.println("Success operation");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Delivery cannot be added");
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Update state boolean.
     *
     * @param IDdelivery the ddelivery
     * @param state      the state
     * @return the boolean
     */
    public boolean update_State(long IDdelivery, long state) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call UPDATE_STATE_DELIVERY(?,?) }")) {


            callStmt.setLong(1, IDdelivery);
            callStmt.setLong(2, state);
            callStmt.execute();

            closeAll();
            System.out.println("Success operation");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("The state must be between 1, 2 or 3\n" +
                    "1\tOPEN\n" +
                    "2\tRUNNING\n" +
                    "3\tCLOSE");
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Remove deliveries run of specific scooter boolean.
     *
     * @param scouterid the scouterid
     * @return the boolean
     */
    public boolean removeDeliveriesRunOfSpecificScooter(long scouterid) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call removeDeliveriesRunOfSpecificScooter(?) }")) {


            callStmt.setLong(1, scouterid);

            callStmt.execute();

            closeAll();
            System.out.println("Success operation");
            return true;
        } catch (SQLException ex) {
            System.out.println("Scooter cannot be removed");
            return false;
        } finally {
            closeAll();
        }
    }


    /**
     * Remove deliveries run of specific drone boolean.
     *
     * @param droneId the drone id
     * @return the boolean
     */
    public boolean removeDeliveriesRunOfSpecificDrone(long droneId) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call removeDeliveriesRunOfSpecificDrone(?) }")) {
            openConnection();


            callStmt.setLong(1, droneId);

            callStmt.execute();

            closeAll();
            System.out.println("Success operation");
            return true;
        } catch (SQLException ex) {
            System.out.println("Drone cannot be removed");
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Id delivery exist boolean.
     *
     * @param idDelivery the id delivery
     * @return the boolean
     */
    public boolean idDeliveryExist(long idDelivery) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call is_delivery_exists_by_id(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, idDelivery);

            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (!rSet.isBeforeFirst()) {
                System.out.println("Delivery doesnt exist.");
                closeAll();
                return false;
            } else {
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
     * Vehicle free boolean.
     *
     * @param idVehicle the id vehicle
     * @return the boolean
     */
    public boolean vehicleFree(Vehicle idVehicle) {
        try (CallableStatement callStmt = getConnection().prepareCall("{? = call vehicleFree(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, idVehicle.getId());
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                if (rSet.getLong(1) == 1) {
                    System.out.println("The vehicle is free to run");
                    return true;
                } else {
                    System.out.println("The vehicle is delivering");
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("The vehicle doesnt exist");
            return false;
        } finally {
            closeAll();
        }
    }

    /**
     * Gets last delivery created.
     *
     * @return the last delivery created
     */
    public long getLastDeliveryCreated() {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_delivery_created() }")) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                long res = rSet.getLong(1);
                closeAll();
                return res;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll();
        }
        throw new RuntimeException("Something went wrong, please try again latter.");
    }

    /**
     * Check id delivery boolean.
     *
     * @param userOrderid the user orderid
     * @return the boolean
     */
    public boolean checkIdDelivery(UserOrder userOrderid) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call has_delivery(?) }")) {

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2,userOrderid.getId());
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (rSet.next()) {
                if (rSet.getLong(1)==0) {
                    closeAll();
                    return true;
                } else {
                    System.out.println(rSet.getLong(1));
                    closeAll();
                    System.out.println("Userorder com delivery");
                    return false;
                }
            }
            return false;
        } catch (
                SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }

    public boolean addScooterDelivery(long idDelivery, long idCourier) {
            try (CallableStatement callStmt = getConnection().prepareCall("{ call prc_add_scooter_delivery(?,?) }")) {
            openConnection();

            callStmt.setLong(1, idDelivery);
            callStmt.setLong(2, idCourier);
            callStmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            closeAll();
        }
    }

    public boolean addDroneDelivery(long idDelivery) {
        try (CallableStatement callStmt = getConnection().prepareCall("{ call prc_add_drone_delivery(?) }")) {
            openConnection();

            callStmt.setLong(1, idDelivery);
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            closeAll();
        }
    }

}