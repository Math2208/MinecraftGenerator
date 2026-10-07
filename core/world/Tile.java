package core.world;

public class Tile {

    private final int x;
    private final int z;
    private final double minLatitude;
    private final double minLongitude;
    private final double maxLatitude;
    private final double maxLongitude;

    public Tile(
            int x,
            int z,
            double minLatitude,
            double minLongitude,
            double maxLatitude,
            double maxLongitude
    ) {
        this.x = x;
        this.z = z;
        this.minLatitude = minLatitude;
        this.minLongitude = minLongitude;
        this.maxLatitude = maxLatitude;
        this.maxLongitude = maxLongitude;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", z=" + z +
                ", latitude=" + minLatitude + " -> " + maxLatitude +
                ", longitude=" + minLongitude + " -> " + maxLongitude +
                '}';
    }
}