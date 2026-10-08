
package generators.roads;

public class RoadMaterialSelector {

    public RoadMaterial selectMaterial(String type) {

        switch (type) {

            case "motorway":
            case "trunk":
            case "primary":
            case "secondary":
            case "tertiary":
            case "residential":
            case "service":
                return RoadMaterial.ASPHALT;

            case "track":
                return RoadMaterial.GRAVEL;

            case "path":
            case "footway":
                return RoadMaterial.DIRT;

            default:
                return RoadMaterial.STONE;
        }
    }
}