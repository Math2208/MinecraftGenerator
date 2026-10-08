package generators.roads;

import core.coordinates.CoordinateConverter;

import java.util.Set;

public class RoadGeometryBuilder {

    private final RoadMinecraftConverter minecraftConverter;
    private final RoadTileMapper tileMapper;

    public RoadGeometryBuilder(
            CoordinateConverter coordinateConverter,
            core.world.TileSystem tileSystem
    ) {
        this.minecraftConverter =
                new RoadMinecraftConverter(
                        coordinateConverter
                );

        this.tileMapper =
                new RoadTileMapper(
                        tileSystem
                );
    }

    public RoadGeometry build(Road road) {

        return new RoadGeometry(
                road,
                minecraftConverter.convertRoad(road),
                tileMapper.getTileKeys(road)
        );
    }
}