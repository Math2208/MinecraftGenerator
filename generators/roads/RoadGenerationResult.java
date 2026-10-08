
package generators.roads;

import core.blocks.MinecraftBlock;

import java.util.List;

public class RoadGenerationResult {

    private final MinecraftRoad road;
    private final List<MinecraftBlock> blocks;

    public RoadGenerationResult(
            MinecraftRoad road,
            List<MinecraftBlock> blocks
    ) {
        this.road = road;
        this.blocks = blocks;
    }

    public MinecraftRoad getRoad() {
        return road;
    }

    public List<MinecraftBlock> getBlocks() {
        return blocks;
    }

    public int getBlockCount() {
        return blocks.size();
    }

    @Override
    public String toString() {
        return "RoadGenerationResult{" +
                "road='" + road.getName() + '\'' +
                ", blockCount=" + blocks.size() +
                '}';
    }
}