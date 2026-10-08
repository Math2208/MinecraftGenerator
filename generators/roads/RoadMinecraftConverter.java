package generators.roads;

import core.coordinates.CoordinateConverter;
import core.coordinates.MinecraftCoordinate;

import java.util.ArrayList;
import java.util.List;

public class RoadMinecraftConverter {

    private final CoordinateConverter converter;

    public RoadMinecraftConverter(
            CoordinateConverter converter
    ) {
        this.converter = converter;
    }

    public MinecraftCoordinate convertPoint(
            RoadPoint point
    ) {

        return converter.convert(
                point.getLatitude(),
                point.getLongitude()
        );
    }

    public List<MinecraftCoordinate> convertRoad(
            Road road
    ) {

        List<MinecraftCoordinate> coordinates =
                new ArrayList<>();

        for (RoadPoint point : road.getPoints()) {

            coordinates.add(
                    convertPoint(point)
            );
        }

        return coordinates;
    }
}