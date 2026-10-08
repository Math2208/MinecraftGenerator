
package generators.roads;

import core.blocks.MinecraftBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadNetworkResult {

    private final List<RoadGenerationResult> roads;

    public RoadNetworkResult(
            List<RoadGenerationResult> roads
    ) {
        this.roads = new ArrayList<>(roads);
    }

    public List<RoadGenerationResult> getRoads() {
        return new ArrayList<>(roads);
    }

    public int getRoadCount() {
        return roads.size();
    }

    public List<MinecraftBlock> getUniqueBlocks() {

        Map<String, MinecraftBlock> uniqueBlocks =
                new HashMap<>();

        for (RoadGenerationResult result : roads) {

            for (MinecraftBlock block : result.getBlocks()) {

                String key =
                        block.getX() + "_"
                        + block.getY() + "_"
                        + block.getZ();

                uniqueBlocks.putIfAbsent(key, block);
            }
        }

        return new ArrayList<>(uniqueBlocks.values());
    }

    public int getUniqueBlockCount() {
        return getUniqueBlocks().size();
    }

    @Override
    public String toString() {
        return "RoadNetworkResult{" +
                "roadCount=" + getRoadCount() +
                ", uniqueBlockCount=" + getUniqueBlockCount() +
                '}';
    }
}