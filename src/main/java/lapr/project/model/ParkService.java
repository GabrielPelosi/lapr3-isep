package lapr.project.model;

import lapr.project.data.ParkDB;

/**
 * The type Park service.
 */
public class ParkService {

    private final ParkDB parkDB;

    /**
     * Instantiates a new Park service.
     */
    public ParkService( ) {
        this.parkDB = new ParkDB();
    }

    /**
     * Add scooter park boolean.
     *
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     * @param pharmacy         the pharmacy
     * @return the boolean
     */
    public boolean addScooterPark(int max_charging_cap, int max_parking_cap, Pharmacy pharmacy){
        Park park = new Park(0,max_charging_cap,max_parking_cap, pharmacy);
        return parkDB.addScooterPark(park);
    }

    /**
     * Add drone park boolean.
     *
     * @param max_charging_cap the max charging cap
     * @param max_parking_cap  the max parking cap
     * @param pharmacy         the pharmacy
     * @return the boolean
     */
    public boolean addDronePark(int max_charging_cap, int max_parking_cap, Pharmacy pharmacy) {
        Park park = new Park(0,max_charging_cap,max_parking_cap, pharmacy);
        return parkDB.addDronePark(park);
    }

    /**
     * Remove park by id boolean.
     *
     * @param idPark the id park
     * @return the boolean
     */
    public boolean removeParkById(long idPark) {
        return parkDB.removeParkById(idPark);
    }

    /**
     * Get last park created long.
     *
     * @return the long
     */
    public long getLastParkCreated(){
        return parkDB.getLastParkCreated();
    }

    /**
     * Is park exists by id boolean.
     *
     * @param idPark the id park
     * @return the boolean
     */
    public boolean isParkExistsById(long idPark){
        return parkDB.isParkExistsById(idPark);
    }
}
