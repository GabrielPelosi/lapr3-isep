package lapr.project.controller;

import java.util.List;

import lapr.project.data.CourierDB;
import lapr.project.data.Delivery_RunDB;
import lapr.project.data.VehicleDB;
import lapr.project.model.Courier;
import lapr.project.model.Delivery;
import lapr.project.model.Route;
import lapr.project.model.Vehicle;

public class ChooseVehicleForRouteController {

    private Route r;
    private Delivery del;

    public ChooseVehicleForRouteController(Route r, Delivery del) {
        this.r = new Route(r);
        this.del = new Delivery(del);
    }



    public List<Vehicle> getSufficientlyChargedScooters(){
        VehicleDB db = new VehicleDB();
        int neededEnergy = r.getCombinedWeightOfList();
        return db.getScootersWithSufficientEnergy(neededEnergy);
    }

    public List<Courier> getFreeCouriers(){
        CourierDB db = new CourierDB();
        return db.getFreeCouriers();
    }

    public boolean addDeliveryWithScooter(Vehicle v, Courier c){
        Delivery_RunDB dbdel = new Delivery_RunDB();
        VehicleDB dbv = new VehicleDB();

        if(dbv.isVehicleScooter(v.getId())) {
            del.setIdvehicle(v);
        }else{
            return false;
        }
        return dbdel.createDelivery(del) && dbdel.addScooterDelivery(del.getIdDelivery(), c.getId());
    }

    public boolean addDeliveryWithDrone(Vehicle v){
        Delivery_RunDB dbdel = new Delivery_RunDB();
        VehicleDB dbv = new VehicleDB();

        if(dbv.isVehicleDrone(v.getId())){
            del.setIdvehicle(v);
        }else{
            return false;
        }

        if(v.getBatCapacity() * v.getMax_battery() < r.getCombinedWeightOfList()){
            return  dbdel.createDelivery(del) && dbdel.addDroneDelivery(del.getIdDelivery()) && addMidwayPharmacy();
        }

        return  dbdel.createDelivery(del) && dbdel.addDroneDelivery(del.getIdDelivery());
    }

    private boolean addMidwayPharmacy() {
        return true;
    }
}
