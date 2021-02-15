package lapr.project.model;

import lapr.project.data.PHUserDB;

/**
 * The type Ph user service.
 */
public class PHUserService {

    private final PHUserDB phUserDB;

    /**
     * Instantiates a new Ph user service.
     */
    public PHUserService() {
        this.phUserDB = new PHUserDB();
    }

    /**
     * Get last ph user created id long.
     *
     * @return the long
     */
    public long getLastPHUserCreatedId(){
        return phUserDB.getLastPHuserCreatedId();
    }

    /**
     * Create new ph user boolean.
     *
     * @param phUser the ph user
     * @return the boolean
     */
    public boolean createNewPHUser(PHUser phUser){
        return phUserDB.addPHuser(phUser);
    }

    /**
     * Exists courier by email boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean existsCourierByEmail(String s) {
        return phUserDB.existsCourierByEmail(s);
    }
}
