package core.coordinates;

public class CoordinateConverter {

    // Approximation de la longueur d'un degré
    // utilisée pour notre premier prototype.
    private static final double METERS_PER_DEGREE_LATITUDE = 111320.0;

    private final double originLatitude;
    private final double originLongitude;

    public CoordinateConverter(double originLatitude, double originLongitude) {
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
    }

    public MinecraftCoordinate convert(double latitude, double longitude) {

        double metersPerDegreeLongitude =
                METERS_PER_DEGREE_LATITUDE
                        * Math.cos(Math.toRadians(originLatitude));

        double x =
                (longitude - originLongitude)
                        * metersPerDegreeLongitude;

        double z =
                (latitude - originLatitude)
                        * METERS_PER_DEGREE_LATITUDE;

        return new MinecraftCoordinate(x, 0, z);
    }

    public double getOriginLatitude() {
        return originLatitude;
    }

    public double getOriginLongitude() {
        return originLongitude;
    }
}