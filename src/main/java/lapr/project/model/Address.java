package lapr.project.model;


import java.util.Objects;

/**
 * The type Address.
 */
public class Address {

    private final Local local;
    private final float lat;
    private final float lon;
    private float elevation;
    private float windSpeed;
    private byte windDirection;

    /**
     * Instantiates a new Address.
     *
     * @param lat           the lat
     * @param lon           the lon
     * @param elevation     the elevation
     * @param local         the local
     * @param windSpeed     the wind speed
     * @param windDirection the wind direction
     */
    public Address(float lat, float lon, float elevation, String local, float windSpeed, byte windDirection) {
        this.local = new Local(local);
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    /**
     * Instantiates a new Address.
     *
     * @param local     the local
     * @param lat       the lat
     * @param lon       the lon
     * @param elevation the elevation
     */
    public Address(String local, float lat, float lon, float elevation) {

        this.local = new Local(local);
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;

    }

    /**
     * Instantiates a new Address.
     *
     * @param local the local
     * @param lat   the lat
     * @param lon   the lon
     */
    public Address(String local, float lat, float lon) {
        this.local = new Local(local);
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Instantiates a new Address.
     *
     * @param address the address
     */
    public Address(Address address) {
        this.local = new Local(address.getLocal());
        this.lat = address.getLat();
        this.lon = address.getLon();
        this.elevation = address.getElevation();

    }

    public Address(float lat, float lon, float elevation) {
        this.local = new Local();
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
    }

    /**
     * Instantiates a new Address.
     *
     * @param lat the lat
     * @param lon the lon
     */
    public Address(float lat, float lon) {
        this.local = new Local("x");
        this.lat = lat;
        this.lon = lon;
        this.elevation = 1;

    }

    /**
     * Gets local.
     *
     * @return the local
     */
    public String getLocal() {
        return local.getLocal();
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * Gets elevation.
     *
     * @return the elevation
     */
    public float getElevation() {
        return elevation;
    }

    /**
     * Gets wind speed.
     *
     * @return the wind speed
     */
    public float getWindSpeed() {
        return windSpeed;
    }

    /**
     * Gets wind direction.
     *
     * @return the wind direction
     */
    public byte getWindDirection() {
        return windDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Float.compare(address.lat, lat) == 0 &&
                Float.compare(address.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }

    @Override
    public String toString() {
        return "Address{" +
                "local=" + local.getLocal() +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
