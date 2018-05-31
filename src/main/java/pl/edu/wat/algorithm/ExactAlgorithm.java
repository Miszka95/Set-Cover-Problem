package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Result;
import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExactAlgorithm extends SetCoverAlgorithm {

    ExactAlgorithm(Universe universe, List<Set> sets) {
        super(universe, sets);
    }

    @Override
    public void solve() {
        int size = sets.size();
        Result result = new Result();
        Result generated;
        for (int i = 0; i < (1 << size); i++) {
            generated = new Result();

            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    generated.addSet(sets.get(j));
                }
            }
            count((long) size + 2);
            if (generated.coversUniverse(universe)) {
                count();
                if (generated.getSets().size() < result.getSets().size() || result.getSets().size() == 0) {
                    result = generated;
                    count();
                }
            }
        }
        results = Collections.singletonList(result);
    }

    private List<Result> findBestResults(List<Result> results) {
        int min = results.stream()
                .mapToInt(e -> e.getSets().size())
                .min()
                .orElseThrow(() -> new UniverseCoverageException(ERROR_MSG));

        return results.stream()
                .filter(u -> u.getSets().size() == min)
                .collect(Collectors.toList());
    }
}
