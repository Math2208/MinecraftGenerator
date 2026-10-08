package core.world;

import core.coordinates.MinecraftCoordinate;

public class WorldTile {

    private final Tile tile;
    private final MinecraftCoordinate minCoordinate;
    private final MinecraftCoordinate maxCoordinate;

    public WorldTile(
            Tile tile,
            MinecraftCoordinate minCoordinate,
            MinecraftCoordinate maxCoordinate
    ) {
        this.tile = tile;
        this.minCoordinate = minCoordinate;
        this.maxCoordinate = maxCoordinate;
    }

    public Tile getTile() {
        return tile;
    }

    public MinecraftCoordinate getMinCoordinate() {
        return minCoordinate;
    }

    public MinecraftCoordinate getMaxCoordinate() {
        return maxCoordinate;
    }

    @Override
    public String toString() {
        return "WorldTile{" +
                "tile=" + tile +
                ", minCoordinate=" + minCoordinate +
                ", maxCoordinate=" + maxCoordinate +
                '}';
    }
}