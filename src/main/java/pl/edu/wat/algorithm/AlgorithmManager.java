package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;
import pl.edu.wat.utils.Configuration;

import java.util.List;

public class AlgorithmManager {

    private final Configuration configuration = Configuration.load();
    private final Universe universe = Universe.fromConfiguration(configuration);
    private final List<Set> sets = Set.fromConfiguration(configuration);

    private final SetCoverAlgorithm exactAlgorithm = new ExactAlgorithm(universe, sets);
    private final SetCoverAlgorithm greedyAlgorithm = new GreedyAlgorithm(universe, sets);

    public void run() {
        greedyAlgorithm.run();
        exactAlgorithm.run();
    }
}
