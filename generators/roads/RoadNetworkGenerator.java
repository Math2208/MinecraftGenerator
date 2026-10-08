
package generators.roads;

import java.util.ArrayList;
import java.util.List;

public class RoadNetworkGenerator {

    private final RoadGenerationPipeline pipeline;

    public RoadNetworkGenerator(
            RoadGenerationPipeline pipeline
    ) {
        this.pipeline = pipeline;
    }

    public List<RoadGenerationResult> generate(
            List<Road> roads,
            int y
    ) {
        List<RoadGenerationResult> results =
                new ArrayList<>();

        for (Road road : roads) {
            RoadGenerationResult result =
                    pipeline.generate(road, y);

            results.add(result);
        }

        return results;
    }

    public RoadNetworkResult generateNetwork(
            List<Road> roads,
            int y
    ) {
        List<RoadGenerationResult> results =
                generate(roads, y);

        return new RoadNetworkResult(results);
    }

    public int getTotalBlockCount(
            List<RoadGenerationResult> results
    ) {
        int total = 0;

        for (RoadGenerationResult result : results) {
            total += result.getBlockCount();
        }

        return total;
    }
}
