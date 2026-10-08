package core.world;

import core.coordinates.CoordinateConverter;
import core.coordinates.MinecraftCoordinate;
import core.coordinates.TileCoordinateConverter;

import java.util.HashMap;
import java.util.Map;

public class WorldTileManager {

    private final Map<String, WorldTile> tiles;

    private final TileSystem tileSystem;
    private final TileCoordinateConverter tileConverter;

    public WorldTileManager(
            TileSystem tileSystem,
            TileCoordinateConverter tileConverter
    ) {
        this.tiles = new HashMap<>();
        this.tileSystem = tileSystem;
        this.tileConverter = tileConverter;
    }

    public void addTile(WorldTile worldTile) {

        Tile tile = worldTile.getTile();

        String key =
                tile.getX() + "_" + tile.getZ();

        tiles.put(key, worldTile);
    }

    public WorldTile getTile(int x, int z) {

        String key = x + "_" + z;

        return tiles.get(key);
    }

    public WorldTile getTile(double latitude, double longitude) {

        Tile tile =
                tileSystem.getTile(
                        latitude,
                        longitude
                );

        String key =
                tile.getX() + "_" + tile.getZ();

        WorldTile worldTile =
                tiles.get(key);

        if (worldTile != null) {
            return worldTile;
        }

        MinecraftCoordinate min =
                tileConverter.getMinMinecraftCoordinate(tile);

        MinecraftCoordinate max =
                tileConverter.getMaxMinecraftCoordinate(tile);

        worldTile =
                new WorldTile(
                        tile,
                        min,
                        max
                );

        addTile(worldTile);

        return worldTile;
    }

    public int getTileCount() {
        return tiles.size();
    }
}