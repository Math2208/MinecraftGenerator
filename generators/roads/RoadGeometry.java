package generators.roads;

import core.coordinates.MinecraftCoordinate;

import java.util.List;
import java.util.Set;

public class RoadGeometry {

    private final Road road;
    private final List<MinecraftCoordinate> coordinates;
    private final Set<String> tileKeys;

    public RoadGeometry(
            Road road,
            List<MinecraftCoordinate> coordinates,
            Set<String> tileKeys
    ) {
        this.road = road;
        this.coordinates = coordinates;
        this.tileKeys = tileKeys;
    }

    public Road getRoad() {
        return road;
    }

    public List<MinecraftCoordinate> getCoordinates() {
        return coordinates;
    }

    public Set<String> getTileKeys() {
        return tileKeys;
    }

    @Override
    public String toString() {
        return "RoadGeometry{" +
                "road='" + road.getName() + '\'' +
                ", coordinates=" + coordinates.size() +
                ", tiles=" + tileKeys.size() +
                '}';
    }
}