package generators.roads;

import core.world.Tile;
import core.world.TileSystem;

import java.util.HashSet;
import java.util.Set;

public class RoadTileMapper {

    private final TileSystem tileSystem;

    public RoadTileMapper(TileSystem tileSystem) {
        this.tileSystem = tileSystem;
    }

    public Set<String> getTileKeys(Road road) {

        Set<String> tileKeys = new HashSet<>();

        for (RoadSegment segment : road.getSegments()) {

            tileKeys.addAll(
                    getTileKeys(segment)
            );
        }

        return tileKeys;
    }

    public Set<String> getTileKeys(RoadSegment segment) {

        Set<String> tileKeys = new HashSet<>();

        RoadPoint start = segment.getStart();
        RoadPoint end = segment.getEnd();

        Tile startTile =
                tileSystem.getTile(
                        start.getLatitude(),
                        start.getLongitude()
                );

        Tile endTile =
                tileSystem.getTile(
                        end.getLatitude(),
                        end.getLongitude()
                );

        int startX = startTile.getX();
        int startZ = startTile.getZ();

        int endX = endTile.getX();
        int endZ = endTile.getZ();

        int steps =
                Math.max(
                        Math.abs(endX - startX),
                        Math.abs(endZ - startZ)
                );

        if (steps == 0) {
            tileKeys.add(
                    startX + "_" + startZ
            );

            return tileKeys;
        }

        for (int i = 0; i <= steps; i++) {

            double progress =
                    (double) i / steps;

            int x =
                    (int) Math.round(
                            startX +
                            (endX - startX) * progress
                    );

            int z =
                    (int) Math.round(
                            startZ +
                            (endZ - startZ) * progress
                    );

            tileKeys.add(
                    x + "_" + z
            );
        }

        return tileKeys;
    }
}