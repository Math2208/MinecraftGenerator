package generators.roads;

public class RoadSegment {

    private final RoadPoint start;
    private final RoadPoint end;

    public RoadSegment(
            RoadPoint start,
            RoadPoint end
    ) {
        this.start = start;
        this.end = end;
    }

    public RoadPoint getStart() {
        return start;
    }

    public RoadPoint getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "RoadSegment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}