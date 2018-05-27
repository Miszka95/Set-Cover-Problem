package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;
import pl.edu.wat.utils.Configuration;
import pl.edu.wat.utils.Coverage;
import pl.edu.wat.utils.Generator;

import java.util.List;

public class AlgorithmManager {

//    private final Configuration configuration = Configuration.load();
    private final Generator generator = Generator.generate(Coverage.MEDIUM);

    private final Universe universe = Universe.create(generator.getUniverse());
    private final List<Set> sets = Set.create(generator.getSets());
//    private final Universe universe = Universe.create(configuration.getUniverse());
//    private final List<Set> sets = Set.create(configuration.getSets());


    private final SetCoverAlgorithm exactAlgorithm = new ExactAlgorithm(universe, sets);
    private final SetCoverAlgorithm greedyAlgorithm = new GreedyAlgorithm(universe, sets);

    public void run() {
        greedyAlgorithm.run();
        exactAlgorithm.run();
    }
}
