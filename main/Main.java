
package main;

import core.blocks.MinecraftBlock;
import core.coordinates.CoordinateConverter;
import core.world.TileSystem;
import generators.roads.Road;
import generators.roads.RoadGenerationPipeline;
import generators.roads.RoadNetworkGenerator;
import generators.roads.RoadNetworkResult;
import generators.roads.RoadPoint;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        double originLatitude = 47.3941;
        double originLongitude = 0.6848;

        CoordinateConverter converter =
                new CoordinateConverter(
                        originLatitude,
                        originLongitude
                );

        TileSystem tileSystem =
                new TileSystem(
                        originLatitude,
                        originLongitude,
                        0.01
                );

        Road road1 = new Road(
                "Route principale",
                "primary"
        );

        road1.addPoint(
                new RoadPoint(47.3950, 0.6860)
        );

        road1.addPoint(
                new RoadPoint(47.4050, 0.6960)
        );

        Road road2 = new Road(
                "Rue residentielle",
                "residential"
        );

        road2.addPoint(
                new RoadPoint(47.4050, 0.6960)
        );

        road2.addPoint(
                new RoadPoint(47.4100, 0.7000)
        );

        List<Road> roads = new ArrayList<>();
        roads.add(road1);
        roads.add(road2);

        RoadGenerationPipeline pipeline =
                new RoadGenerationPipeline(
                        converter,
                        tileSystem
                );

        RoadNetworkGenerator networkGenerator =
                new RoadNetworkGenerator(pipeline);

        RoadNetworkResult network =
                networkGenerator.generateNetwork(
                        roads,
                        64
                );

        System.out.println("=== RESEAU ROUTIER COMPLET ===");
        System.out.println(network);

        System.out.println();
        System.out.println("Nombre de routes : "
                + network.getRoadCount());

        System.out.println("Nombre de positions uniques : "
                + network.getUniqueBlockCount());

        System.out.println();
        System.out.println("Premiers blocs uniques :");

        List<MinecraftBlock> blocks =
                network.getUniqueBlocks();

        for (int i = 0; i < Math.min(10, blocks.size()); i++) {
            System.out.println(blocks.get(i));
        }
    }
}
