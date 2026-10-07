package main;

import core.world.Tile;
import core.world.TileSystem;

public class Main {

    public static void main(String[] args) {

        double latitudeOrigine = 47.3941;
        double longitudeOrigine = 0.6848;

        TileSystem tileSystem =
                new TileSystem(
                        latitudeOrigine,
                        longitudeOrigine,
                        0.01
                );

        double latitude = 47.3950;
        double longitude = 0.6860;

        Tile tile =
                tileSystem.getTile(
                        latitude,
                        longitude
                );

        System.out.println("Tuile trouvée :");
        System.out.println(tile);
    }
}