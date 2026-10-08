package generators.roads;

public class RoadPoint {

    private final double latitude;
    private final double longitude;

    public RoadPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "RoadPoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}