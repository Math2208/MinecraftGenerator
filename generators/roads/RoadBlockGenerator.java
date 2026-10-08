
package generators.roads;

import core.blocks.MinecraftBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoadBlockGenerator {

    private final MinecraftBlockMapper blockMapper;

    public RoadBlockGenerator() {
        this.blockMapper = new MinecraftBlockMapper();
    }

    public List<MinecraftBlock> generateBlocks(
            MinecraftRoad road,
            Set<String> surface,
            int y
    ) {
        List<MinecraftBlock> blocks = new ArrayList<>();

        String blockId =
                blockMapper.getBlockId(road.getMaterial());

        for (String position : surface) {

            String[] coordinates = position.split("_");

            int x = Integer.parseInt(coordinates[0]);
            int z = Integer.parseInt(coordinates[2]);

            MinecraftBlock block =
                    new MinecraftBlock(
                            x,
                            y,
                            z,
                            blockId
                    );

            blocks.add(block);
        }

        return blocks;
    }
}