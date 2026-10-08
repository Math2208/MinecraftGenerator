
package generators.roads;

import core.coordinates.MinecraftCoordinate;

import java.util.ArrayList;
import java.util.List;

public class RoadPathGenerator {

    public List<MinecraftCoordinate> generatePath(
            MinecraftRoad road
    ) {
        List<MinecraftCoordinate> path =
                new ArrayList<>();

        List<MinecraftCoordinate> points =
                road.getCoordinates();

        for (int i = 0; i < points.size() - 1; i++) {

            MinecraftCoordinate start = points.get(i);
            MinecraftCoordinate end = points.get(i + 1);

            double dx = end.getX() - start.getX();
            double dz = end.getZ() - start.getZ();

            int steps = (int) Math.ceil(
                    Math.max(Math.abs(dx), Math.abs(dz))
            );

            if (steps == 0) {
                if (path.isEmpty()) {
                    path.add(start);
                }
                continue;
            }

            for (int j = 0; j < steps; j++) {

                double progress = (double) j / steps;

                double x = start.getX() + dx * progress;
                double z = start.getZ() + dz * progress;

                path.add(
                        new MinecraftCoordinate(
                                Math.round(x),
                                0,
                                Math.round(z)
                        )
                );
            }
        }

        if (!points.isEmpty()) {
            path.add(points.get(points.size() - 1));
        }

        return path;
    }
}