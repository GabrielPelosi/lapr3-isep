package lapr.project.model;

import lapr.project.data.CourierDB;

/**
 * The type Courier service.
 */
public class CourierService {

    private final CourierDB courierDB;
    private final  PHUserService phUserService;

    /**
     * Instantiates a new Courier service.
     */
    public CourierService() {
        this.courierDB = new CourierDB();
        this.phUserService = new PHUserService();
    }

    /**
     * Create new courier boolean.
     *
     * @param userName the user name
     * @param email    the email
     * @param password the password
     * @param pharmacy the pharmacy
     * @return the boolean
     */
    public boolean createNewCourier(String userName, String email, String password, Pharmacy pharmacy){
        PHUser phUser = new PHUser(0,2,null,userName,password,email);
        Courier courier = new Courier(0,phUser,pharmacy);


        if (!phUserService.createNewPHUser(phUser))
            return false;

        long phuserCreateId = phUserService.getLastPHUserCreatedId();

        phUser.setId(phuserCreateId);
        boolean createCourier=false;
        return courierDB.createNewCourier(courier);
    }


    /**
     * Remove courier by email boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean removeCourierByEmail(String s) {
        if (!phUserService.existsCourierByEmail(s)){
            return false;
        }
        return courierDB.removeCourierByEmail(s);
    }
}
