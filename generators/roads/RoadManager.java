package generators.roads;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {

    private final List<Road> roads;

    public RoadManager() {
        roads = new ArrayList<>();
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public Road getRoad(int index) {
        return roads.get(index);
    }

    public int getRoadCount() {
        return roads.size();
    }

    public List<Road> getRoads() {
        return roads;
    }
}