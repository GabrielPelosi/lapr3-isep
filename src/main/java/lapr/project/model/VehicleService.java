package lapr.project.model;

import lapr.project.data.VehicleDB;

/**
 * The type Vehicle service.
 */
public class VehicleService {
    private final VehicleDB vehicleDB;

    /**
     * Instantiates a new Vehicle service.
     */
    public VehicleService() {
        this.vehicleDB = new VehicleDB();
    }

    /**
     * Add drone boolean.
     *
     * @param pharmacyId     the pharmacy id
     * @param batCapacity    the bat capacity
     * @param max_battery    the max battery
     * @param actual_battery the actual battery
     * @param aerodinamic    the aerodinamic
     * @param frontarea      the frontarea
     * @param weight         the weight
     * @return the boolean
     */
    public boolean addDrone(long pharmacyId, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight ){
        return vehicleDB.createDrone((new Vehicle(0, new Pharmacy(pharmacyId,null),batCapacity,max_battery,actual_battery,aerodinamic,frontarea,weight)));

    }

    /**
     * Remove drone byid boolean.
     *
     * @param droneId the drone id
     * @return the boolean
     */
    public boolean removeDroneByid(long droneId) {
        return vehicleDB.removeDrone(droneId);

    }


    /**
     * Add scooter boolean.
     *
     * @param pharmacyId     the pharmacy id
     * @param batCapacity    the bat capacity
     * @param max_battery    the max battery
     * @param actual_battery the actual battery
     * @param aerodinamic    the aerodinamic
     * @param frontarea      the frontarea
     * @param weight         the weight
     * @return the boolean
     */
    public boolean addScooter(long pharmacyId, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight ){
        return vehicleDB.createScooter((new Vehicle(0, new Pharmacy(pharmacyId,null),batCapacity,max_battery,actual_battery,aerodinamic,frontarea,weight)));
    }

    /**
     * Remove scooter by id boolean.
     *
     * @param scooterid the scooterid
     * @return the boolean
     */
    public boolean removeScooterById(long scooterid) {
        return vehicleDB.removeScooter(scooterid);

    }

    /**
     * Gets drone.
     *
     * @return the drone
     */
    public long getlastDrone() {
        return vehicleDB.getlastDrone();
    }

    /**
     * Gets scooter.
     *
     * @return the scooter
     */
    public long getlastScooter() {
        return vehicleDB.getlastScooter();
    }

    /**
     * Is vehicle exists by id boolean.
     *
     * @param vehicleID the vehicle id
     * @return the boolean
     */
    public boolean isVehicleExistsById(long vehicleID) {
        return vehicleDB.isVehicleExistsById(vehicleID);
    }
}
