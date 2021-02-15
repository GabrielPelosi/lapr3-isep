package lapr.project.data;

import lapr.project.controller.*;
import lapr.project.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Scenario loader.
 */
public class ScenarioLoader {

    /**
     * Loads Users into the DB
     *
     * @param filePath       the file path
     * @param fieldSeparator the field separator
     * @return int
     */
    public int loadUsers(String filePath, String fieldSeparator) {
        int nUsers = 0;
        int n = 1;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        for (ArrayList<String> data : list) {
            System.out.println("Client number " + n);
            //#latitude;longitude;elevation;street;name;email;pass;nif
            float userLat = Float.parseFloat(data.get(0));
            float userLon = Float.parseFloat(data.get(1));
            float userElev = Float.parseFloat(data.get(2));
            String userStreet = data.get(3);
            String userName = data.get(4);
            String userEmail = data.get(5);
            String userPass = data.get(6);
            int userNif = Integer.parseInt(data.get(7));

            //String userName, String email, String password, Address address, int nif
            RegisterCostumerController controller = new RegisterCostumerController();
            if (controller.registerCostumer(userName, userEmail, userPass, new Address(userStreet, userLat, userLon, userElev), userNif)) {
                nUsers++;
            }

            n++;
        }
        return nUsers;
    }

    /**
     * Loads Users into the DB
     *
     * @param filePath       the file path
     * @param fieldSeparator the field separator
     * @return int
     */
    public int loadScooters(String filePath, String fieldSeparator) {
        int nScoo = 0;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        int n = 1;
        for (ArrayList<String> data : list) {
            System.out.println("Scooter number " + n);
            //#pharmacyId;weight;max battery capacity;actual battery capacity;aerodynamic coefficient;frontal area
            long parmacyId = Long.parseLong(data.get(0));
            double weight = Double.parseDouble(data.get(1));
            double max_bat = Float.parseFloat(data.get(2));
            float act_bat = Float.parseFloat(data.get(3));
            double aero = Float.parseFloat(data.get(4));
            double frontal = Float.parseFloat(data.get(5));


            // long pharmacyId, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight
            AddScooterController controller = new AddScooterController();
            if (controller.addScooter(parmacyId, act_bat, max_bat, act_bat, aero, frontal, weight)) {
                nScoo++;
            }

            n++;
        }
        return nScoo;
    }

    /**
     * Loads Users into the DB
     *
     * @param filePath       the file path
     * @param fieldSeparator the field separator
     * @return int
     */
    public int loadDrones(String filePath, String fieldSeparator) {
        int nDrone = 1;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        int n = 0;
        for (ArrayList<String> data : list) {
            System.out.println("Drone number " + n);
            //#pharmacyId;weight;max battery capacity;actual battery capacity;aerodynamic coefficient;frontal area
            long parmacyId = Long.parseLong(data.get(0));
            double weight = Double.parseDouble(data.get(1));
            double max_bat = Float.parseFloat(data.get(2));
            float act_bat = Float.parseFloat(data.get(3));
            double aero = Float.parseFloat(data.get(4));
            double frontal = Float.parseFloat(data.get(5));


            // long pharmacyId, float batCapacity, double max_battery, double actual_battery, double aerodinamic, double frontarea, double weight
            AddDroneController controller = new AddDroneController();
            if (controller.addDrone(parmacyId, act_bat, max_bat, act_bat, aero, frontal, weight)) {
                nDrone++;
            }

            n++;
        }
        return nDrone;
    }


    /**
     * Loads Users into the DB
     *
     * @param filePath       the file path
     * @param fieldSeparator the field separator
     * @return int
     */
    public int loadPharmcy(String filePath, String fieldSeparator) {
        int nPhar = 0;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        int n = 1;
        for (ArrayList<String> data : list) {
            System.out.println("Pharmacy number " + n);
            //#latitude;longitude;elevation;address description;charging park;parking spaces
            float lat = Float.parseFloat(data.get(0));
            float lon = Float.parseFloat(data.get(1));
            float elev = Float.parseFloat(data.get(2));
            String address = data.get(3);

            double charg = Float.parseFloat(data.get(4));
            double park = Float.parseFloat(data.get(5));


            //Address address
            AddPharmacyController controller = new AddPharmacyController();
            if (controller.addPharmacy(new Address(address, lat, lon, elev))) {
                nPhar++;
            }
            n++;
        }
        return nPhar;
    }


    public int loadUserOrders(String filePath, String fieldSeparator) {
        int nOrder = 0;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        List<Product> productsToBuy = new ArrayList<>();

        int n = 1;
        for (ArrayList<String> data : list) {
            System.out.println("Order number " + n);
            //#product;price;qnt;weight;costumerID;pharmacyID
            long prodId = Long.parseLong(data.get(0));
            double prodPrice = Double.parseDouble(data.get(1));
            int prodQnt = Integer.parseInt(data.get(2));
            double prodWieght = Double.parseDouble(data.get(3));
            long custID = Long.parseLong(data.get(4));
            long pharID = Long.parseLong(data.get(5));
            float pharLat = Float.parseFloat(data.get(6));
            float pharLon = Float.parseFloat(data.get(7));

            //id,description, price, weight,quantity
            Product product = new Product(prodId, "userOrderDemonstration", prodPrice, prodWieght, prodQnt);
            productsToBuy.add(product);
            Costumer costumer = new Costumer(custID, null, 99999999);
            Pharmacy pharmacy = new Pharmacy(pharID, new Address(pharLat, pharLon));
            //List<Product> products, Costumer costumer, long deliveryRun, Pharmacy pharmacy, boolean payWithCredits
            CreateNewUserOrderController controller = new CreateNewUserOrderController();
            if (controller.createNewOrder(productsToBuy, costumer, 0, pharmacy, true)) {
                nOrder++;
            }
            productsToBuy.clear();
            n++;
        }
        return nOrder;
    }


    public int loadDeliveries(String filePath, String fieldSeparator) {
        int nDeli = 0;
        List<ArrayList<String>> list = getDataFromFile(filePath, fieldSeparator);
        List<UserOrder> userOrdersAvailables = new ArrayList<>();

        int n = 1;
        for (ArrayList<String> data : list) {
            System.out.println("delivery: " + n);
            //#vehicleID;userOrderID;userOrderWeight;pharmacyID;
            long vID = Long.parseLong(data.get(0));

            long userOrderID = Long.parseLong(data.get(1));
            double userOrderWeight = Double.parseDouble(data.get(2));

            long pharID = Long.parseLong(data.get(3));

            DeliveryController deliveryController = new DeliveryController();



            Pharmacy pharmacy = new Pharmacy(pharID, null);
            Vehicle vehicle = new Vehicle(vID, pharmacy, 12f);
            UserOrder userOrder = new UserOrder(userOrderID, null, pharmacy, null, 0, userOrderWeight);
            userOrdersAvailables.add(userOrder);
            //Vehicle vehicleID, long weight, List<UserOrder> userOrderList, Pharmacy pharmacy
            if (deliveryController.addDelivery(vehicle, userOrdersAvailables, pharmacy)) {
                nDeli++;
            }
            userOrdersAvailables.clear();
            n++;
        }
        return nDeli;
    }


    /**
     * Gets data from a file and returns a List with String for each line
     *
     * @param filePath
     * @param fieldSeparator
     * @return
     */
    private List<ArrayList<String>> getDataFromFile(String filePath, String fieldSeparator) {
        List<ArrayList<String>> data = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                if (!line.startsWith("#") && !line.isEmpty()) {
                    String[] lineData = line.split(fieldSeparator);
                    ArrayList<String> lineElem = new ArrayList<>();
                    for (String item : lineData) {
                        lineElem.add(item.trim());
                    }
                    data.add(lineElem);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                }
            }
        }
        return data;
    }


}
