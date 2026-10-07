package core.world;

public class TileSystem {

    // Taille d'une tuile en degrés.
    // Petite valeur = plus de précision,
    // mais davantage de tuiles.
    private final double tileSize;

    private final double originLatitude;
    private final double originLongitude;

    public TileSystem(
            double originLatitude,
            double originLongitude,
            double tileSize
    ) {
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
        this.tileSize = tileSize;
    }

    public Tile getTile(double latitude, double longitude) {

        int x = (int) Math.floor(
                (longitude - originLongitude) / tileSize
        );

        int z = (int) Math.floor(
                (latitude - originLatitude) / tileSize
        );

        double minLatitude =
                originLatitude + z * tileSize;

        double minLongitude =
                originLongitude + x * tileSize;

        double maxLatitude =
                minLatitude + tileSize;

        double maxLongitude =
                minLongitude + tileSize;

        return new Tile(
                x,
                z,
                minLatitude,
                minLongitude,
                maxLatitude,
                maxLongitude
        );
    }
}