package core.coordinates;

import core.world.Tile;

public class TileCoordinateConverter {

    private final CoordinateConverter converter;

    public TileCoordinateConverter(CoordinateConverter converter) {
        this.converter = converter;
    }

    public MinecraftCoordinate getMinMinecraftCoordinate(Tile tile) {

        return converter.convert(
                tile.getMinLatitude(),
                tile.getMinLongitude()
        );
    }

    public MinecraftCoordinate getMaxMinecraftCoordinate(Tile tile) {

        return converter.convert(
                tile.getMaxLatitude(),
                tile.getMaxLongitude()
        );
    }
}