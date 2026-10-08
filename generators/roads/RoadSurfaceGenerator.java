
package generators.roads;

import core.coordinates.MinecraftCoordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoadSurfaceGenerator {

    public Set<String> generateSurface(
            MinecraftRoad road,
            List<MinecraftCoordinate> path
    ) {
        Set<String> surface = new HashSet<>();

        int width = road.getWidth();

        if (path.isEmpty()) {
            return surface;
        }

        for (int i = 0; i < path.size(); i++) {

            MinecraftCoordinate point = path.get(i);

            MinecraftCoordinate previous =
                    path.get(Math.max(0, i - 1));

            MinecraftCoordinate next =
                    path.get(Math.min(path.size() - 1, i + 1));

            double dx = next.getX() - previous.getX();
            double dz = next.getZ() - previous.getZ();

            double length = Math.sqrt(dx * dx + dz * dz);

            if (length == 0) {
                addWidth(surface, point, width, 1, 0);
                continue;
            }

            // Direction perpendiculaire à la route.
            double perpendicularX = -dz / length;
            double perpendicularZ = dx / length;

            addWidth(
                    surface,
                    point,
                    width,
                    perpendicularX,
                    perpendicularZ
            );
        }

        return surface;
    }

    private void addWidth(
            Set<String> surface,
            MinecraftCoordinate point,
            int width,
            double perpendicularX,
            double perpendicularZ
    ) {
        int startOffset = -(width / 2);

        for (int offset = startOffset;
             offset < startOffset + width;
             offset++) {

            int x = (int) Math.round(
                    point.getX() + perpendicularX * offset
            );

            int z = (int) Math.round(
                    point.getZ() + perpendicularZ * offset
            );

            surface.add(x + "_0_" + z);
        }
    }
}
