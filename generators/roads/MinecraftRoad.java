
package generators.roads;

import core.coordinates.MinecraftCoordinate;

import java.util.List;

public class MinecraftRoad {

    private final String name;
    private final String type;
    private final int width;
    private final List<MinecraftCoordinate> coordinates;
    private final RoadMaterial material;

    public MinecraftRoad(
            String name,
            String type,
            int width,
            List<MinecraftCoordinate> coordinates,
            RoadMaterial material
    ) {
        this.name = name;
        this.type = type;
        this.width = width;
        this.coordinates = coordinates;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public List<MinecraftCoordinate> getCoordinates() {
        return coordinates;
    }

    public RoadMaterial getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "MinecraftRoad{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", width=" + width +
                ", material=" + material +
                ", coordinates=" + coordinates.size() +
                '}';
    }
}