
package generators.roads;

public class MinecraftBlockMapper {

    public String getBlockId(RoadMaterial material) {

        switch (material) {

            case ASPHALT:
                return "minecraft:black_concrete";

            case GRAVEL:
                return "minecraft:gravel";

            case DIRT:
                return "minecraft:dirt";

            case STONE:
                return "minecraft:stone";

            default:
                return "minecraft:stone";
        }
    }
}