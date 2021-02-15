package lapr.project.data;

import lapr.project.model.PHUser;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Ph user db.
 */
public class PHUserDB extends DataHandler{

    /*
    public PHUser getPHUser(long id) {

        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call getPHUser(?) }");) {


            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setLong(2, id);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long userID = rSet.getLong(1);
                long userRole = rSet.getLong(2);
                long userAdd = rSet.getLong(3);
                String email = rSet.getString(4);
                String userName = rSet.getString(4);
                String passwd = rSet.getString(4);

                return new PHUser(userID, userRole, new AddressDB().getAddress(userAdd), userName, passwd, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No PHUser with ID:" + id);
    }

     */


    /**
     * Remove ph user.
     *
     * @param uid the uid
     */
    public void removePHUser(long uid) {

        try( CallableStatement callStmt = getConnection().prepareCall("{ call removePHUser(?) }")) {

            callStmt.setLong(1, uid);

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

        try(CallableStatement callStmt = getConnection().prepareCall("{ ? = call getHighestPHUserID() }")) {

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.NUMBER);

            // Executa a invocação da função.
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                long id = rSet.getLong(1);


                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No PHUser created:");
    }

    /**
     * Add p huser boolean.
     *
     * @param phUser the ph user
     * @return the boolean
     */
//Method dows not need phuser id, increments automatic
    public boolean addPHuser(PHUser phUser){
        try(CallableStatement callStmt = getConnection().prepareCall("{ call addPHUser(?,?,?,?) }")) {



            callStmt.setLong(1, phUser.getIdRole());
            callStmt.setString(2, phUser.getEmail());
            callStmt.setString(3, phUser.getUserName());
            callStmt.setString(4, phUser.getPasswd());

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
     * Get last p huser created id long.
     *
     * @return the long
     */
    public long getLastPHuserCreatedId(){

        try (CallableStatement callStmt = getConnection().prepareCall("{ ? = call get_last_phuser_created() }")){

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
     * Exists courier by email boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean existsCourierByEmail(String s) {
        try(CallableStatement callStmt = getConnection().prepareCall("{ ? =  call get_phuser_by_email(?) }");) {
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, s);
            callStmt.execute();
            ResultSet rSet = (ResultSet) callStmt.getObject(1);
            if (!rSet.isBeforeFirst()) {
                closeAll();
                return false;
            }else {
                closeAll();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeAll();
        }
    }
}


