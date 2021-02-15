package lapr.project.utils.PhysicsCalculations;

import lapr.project.model.Address;

/**
 * The type Distance.
 */
public abstract class Distance {

    /**
     * Calculate distance between two addresses double.
     *
     * @param longitude1 the longitude 1
     * @param latitude1  the latitude 1
     * @param longitude2 the longitude 2
     * @param latitude2  the latitude 2
     * @param elev1      the elev 1
     * @param elev2      the elev 2
     * @return the double
     */
    public static double calculateDistanceBetweenTwoAddresses(double longitude1, double latitude1,
                                                              double longitude2, double latitude2,
                                                              double elev1, double elev2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2))
                + ((Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)))
                * (Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2)));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = elev1 - elev2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.round(Math.sqrt(distance));



        /*
        double a, distance, c;
        double r = 6372.795477598;

        a = Math.sin(Math.toRadians(latitude2 - latitude1) / 2)
                * Math.sin(Math.toRadians(latitude2 - latitude1) / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(Math.toRadians(longitude2 - longitude1) / 2)
                * Math.sin(Math.toRadians(longitude2 - longitude1) / 2);

        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        distance = Math.round(r * c);

        return distance;

         */
    }

    /**
     * Calculate distance between two addresses double.
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @return the double
     */
    public static double calculateDistanceBetweenTwoAddresses(Address a1, Address a2){
        return calculateDistanceBetweenTwoAddresses(a1.getLon(), a1.getLat(), a2.getLon(), a2.getLat(),a1.getElevation(),a2.getElevation());
    }


}
