package lapr.project.model;

import lapr.project.data.NotificationDB;

/**
 * The type Notification service.
 */
public class NotificationService {

    private final NotificationDB notificationDB;

    /**
     * Instantiates a new Notification service.
     */
    public NotificationService( ) {
        this.notificationDB = new NotificationDB();
    }

    /**
     * Create notification of invalid product boolean.
     *
     * @param costumer the costumer
     * @param s        the s
     * @return the boolean
     */
    public boolean createNotificationOfInvalidProduct(Costumer costumer , String s) {
            return notificationDB.createNotificationOfClient(costumer,s);
    }
}
