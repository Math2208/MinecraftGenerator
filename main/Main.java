package main;

import core.coordinates.CoordinateConverter;
import core.coordinates.TileCoordinateConverter;
import core.world.TileSystem;
import core.world.WorldTile;
import core.world.WorldTileManager;

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

        CoordinateConverter converter =
                new CoordinateConverter(
                        latitudeOrigine,
                        longitudeOrigine
                );

        TileCoordinateConverter tileConverter =
                new TileCoordinateConverter(converter);

        WorldTileManager manager =
                new WorldTileManager(
                        tileSystem,
                        tileConverter
                );

        WorldTile tile1 =
                manager.getTile(47.3950, 0.6860);

        WorldTile tile2 =
                manager.getTile(47.4050, 0.6960);

        WorldTile tile3 =
                manager.getTile(47.4150, 0.7060);

        System.out.println("Tuile 1 :");
        System.out.println(tile1);

        System.out.println();

        System.out.println("Tuile 2 :");
        System.out.println(tile2);

        System.out.println();

        System.out.println("Tuile 3 :");
        System.out.println(tile3);

        System.out.println();

        System.out.println(
                "Nombre total de tuiles : "
                        + manager.getTileCount()
        );
    }
}