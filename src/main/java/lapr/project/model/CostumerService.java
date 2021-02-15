package lapr.project.model;

import lapr.project.data.CostumerDB;

/**
 * The type Costumer service.
 */
public class CostumerService {

    private final CostumerDB costumerDB;
    private final PHUserService phUserService;
    private final AddressService addressService;

    /**
     * Instantiates a new Costumer service.
     */
    public CostumerService() {
        this.costumerDB = new CostumerDB();
        this.phUserService = new PHUserService();
        this.addressService = new AddressService();
    }


    /**
     * Update credtis of costumer by id boolean.
     *
     * @param costumerId the costumer id
     * @param v          the v
     * @return the boolean
     */
    public boolean updateCredtisOfCostumerById(long costumerId, double v) {
        if (!costumerDB.isCostumerExists(costumerId)){
            return false;
        }else {
            return costumerDB.updateCredtisOfCostumerById(costumerId,v);
        }
    }

    /**
     * Has enough credits by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean hasEnoughCreditsById(long id) {
        if(!costumerDB.isCostumerExists(id)){
            return false;
        }
        return costumerDB.hasEnoughCredits(id);
    }

    /**
     * Pay delivery tax with credits boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean payDeliveryTaxWithCredits(long id) {
        if(!costumerDB.isCostumerExists(id)){
            return false;
        }
        return costumerDB.payDeliveryTaxWithCredits(id);
    }

    /**
     * Register costumer boolean.
     *
     * @param userName the user name
     * @param email    the email
     * @param password the password
     * @param address  the address
     * @param nif      the nif
     * @return the boolean
     */
    public boolean registerCostumer(String userName, String email, String password, Address address, long nif) {
        PHUser newPhUser = new PHUser(0,3,address,userName,password,email);

        if(!phUserService.createNewPHUser(newPhUser)) return false;
        long lastPhuserId = phUserService.getLastPHUserCreatedId();


        if(! addressService.addAddress(address)) return false;



        Costumer costumer = new Costumer(0,newPhUser,nif,address);
        costumer.getIdUser().setId(lastPhuserId);
        return costumerDB.createNewCostumer(costumer,lastPhuserId);

    }
}
