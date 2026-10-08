
package generators.roads;

import core.blocks.MinecraftBlock;
import core.coordinates.CoordinateConverter;
import core.coordinates.MinecraftCoordinate;
import core.world.TileSystem;

import java.util.List;
import java.util.Set;

public class RoadGenerationPipeline {

    private final RoadGeometryBuilder geometryBuilder;
    private final MinecraftRoadBuilder roadBuilder;
    private final RoadPathGenerator pathGenerator;
    private final RoadSurfaceGenerator surfaceGenerator;
    private final RoadBlockGenerator blockGenerator;

    public RoadGenerationPipeline(
            CoordinateConverter converter,
            TileSystem tileSystem
    ) {
        geometryBuilder =
                new RoadGeometryBuilder(converter, tileSystem);

        roadBuilder = new MinecraftRoadBuilder();
        pathGenerator = new RoadPathGenerator();
        surfaceGenerator = new RoadSurfaceGenerator();
        blockGenerator = new RoadBlockGenerator();
    }

    public RoadGenerationResult generate(
            Road road,
            int y
    ) {
        RoadGeometry geometry =
                geometryBuilder.build(road);

        MinecraftRoad minecraftRoad =
                roadBuilder.build(geometry);

        List<MinecraftCoordinate> path =
                pathGenerator.generatePath(minecraftRoad);

        Set<String> surface =
                surfaceGenerator.generateSurface(
                        minecraftRoad,
                        path
                );

        List<MinecraftBlock> blocks =
                blockGenerator.generateBlocks(
                        minecraftRoad,
                        surface,
                        y
                );

        return new RoadGenerationResult(
                minecraftRoad,
                blocks
        );
    }
}