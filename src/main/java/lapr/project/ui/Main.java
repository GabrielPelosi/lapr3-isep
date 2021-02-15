package lapr.project.ui;

import lapr.project.controller.ChooseDeliveryMethodController;
import lapr.project.controller.SendEmailWithChargeInformationController;
import lapr.project.data.DataHandler;
import lapr.project.data.ScenarioLoader;
import lapr.project.model.*;

import javax.mail.MessagingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Main.
 *
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws IOException, SQLException, MessagingException {
        CalculatorExample calculatorExample = new CalculatorExample();
        int value = calculatorExample.sum(3, 5);

        if (LOGGER.isLoggable(Level.INFO))
            LOGGER.log(Level.INFO, String.valueOf(value));

        //load database properties

        try {
            Properties properties =
                    new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //Initial Database Setup
        DataHandler dh = new DataHandler();
        //dh.scriptRunner("target/test-classes/demo_jdbc.sql");

        //delete connectios to next scenario
        dh.scriptRunner("sql/Scripts/deleteConnections.sql");

        //Load scenarios to data base


        /*
        String op = "2";
        switch (op){
            case "1":
                System.out.println("case 1");
                dh.scriptRunner("sql/Scripts/insertConnections1.sql");
                //Delivery trindade to cais da riberira

                break;
            case "2":
                System.out.println("case 2");
                dh.scriptRunner("sql/Scripts/insertConnections2.sql");
                //Delivery trindade to cais da riberira
                break;
            case "3":
                System.out.println("case 3");
                dh.scriptRunner("sql/Scripts/insertConnections3.sql");
                //Delivery trindade to cais da riberira and bolhão
                break;
            default:
                System.out.println("Error");
        }

         */

        ScenarioLoader scenarioLoader = new ScenarioLoader();
        //int a = scenarioLoader.loadScooters("fileTemplates/escooters.csv", ";");
        //System.out.println("Scooters adicionadas: " + a);
        //a = scenarioLoader.loadDrones("fileTemplates/drones.csv", ";");
        //System.out.println("Drones adicionadas: " + a);
        //int a;
        //a = scenarioLoader.loadUsers("fileTemplates/clients.csv", ";");
        //System.out.println("Users registados: " + a);
        //a = scenarioLoader.loadPharmcy("fileTemplates/pharmacy-castelo-do-queijo.csv", ";");
        //System.out.println("Farmácias adicionadas: " + a);
        //a = scenarioLoader.loadPharmcy("fileTemplates/pharmacy-trindade.csv", ";");

        //create orders, invalid orders, payed taxed orders and back-orders
        //int userOrdersCreated = scenarioLoader.loadUserOrders("fileTemplates/userOrders.csv", ";");
        //System.out.println("Orders created: " + userOrdersCreated);
        //int a = scenarioLoader.loadDeliveries("fileTemplates/delivery.csv", ";");
        //System.out.println(a + " deliveries created");
        //SendEmailWithChargeInformationController ctrobj = new SendEmailWithChargeInformationController();
        //ctrobj.sendEmailWithChargeInfo();


        /*
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,1));
        products.add(new Product(2,2));
        products.add(new Product(3,3));

        List<UserOrder> userOrderList = new ArrayList<>();
        //Trindade
        Pharmacy pharmacy = new Pharmacy(1,new Address(41.15227f,-8.60929f,104f));
        //Cais da Ribeira
        UserOrder userOrder = new UserOrder(1,new Costumer(1,null,99999999,new Address(41.14063f,-8.61118f,25f)),products,1);
        userOrderList.add(userOrder);

        //TRindade to Cais da Ribeira ida e volta
        Delivery delivery = new Delivery(1, new Vehicle(1,pharmacy,1,1,1,1,1,1),23,userOrderList,pharmacy);
        ChooseDeliveryMethodController controller = new ChooseDeliveryMethodController(delivery,0);
        Route route = controller.getLandBasedRoute();
        System.out.println(route.toString());












        dh.scriptRunner("sql/Scripts/deleteConnections.sql");
         */

    }
}

