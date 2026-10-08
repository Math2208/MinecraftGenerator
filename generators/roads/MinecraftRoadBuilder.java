
package generators.roads;

public class MinecraftRoadBuilder {

    private final RoadMaterialSelector materialSelector =
            new RoadMaterialSelector();

    public MinecraftRoad build(RoadGeometry geometry) {

        Road road = geometry.getRoad();

        int width = getWidth(road.getType());

        RoadMaterial material =
                materialSelector.selectMaterial(road.getType());

        return new MinecraftRoad(
                road.getName(),
                road.getType(),
                width,
                geometry.getCoordinates(),
                material
        );
    }

    private int getWidth(String type) {

        switch (type) {

            case "motorway":
                return 7;

            case "trunk":
                return 6;

            case "primary":
            case "secondary":
                return 5;

            case "tertiary":
                return 4;

            case "residential":
                return 3;

            case "service":
                return 2;

            default:
                return 3;
        }
    }
}