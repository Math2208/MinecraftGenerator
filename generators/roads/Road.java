package generators.roads;

import java.util.ArrayList;
import java.util.List;

public class Road {

    private final String name;
    private final String type;
    private final List<RoadPoint> points;

    public Road(String name, String type) {
        this.name = name;
        this.type = type;
        this.points = new ArrayList<>();
    }

    public void addPoint(RoadPoint point) {
        points.add(point);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<RoadPoint> getPoints() {
        return points;
    }

    public List<RoadSegment> getSegments() {

        List<RoadSegment> segments = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {

            RoadPoint start = points.get(i);
            RoadPoint end = points.get(i + 1);

            segments.add(
                    new RoadSegment(start, end)
            );
        }

        return segments;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", points=" + points.size() +
                ", segments=" + getSegments().size() +
                '}';
    }
}