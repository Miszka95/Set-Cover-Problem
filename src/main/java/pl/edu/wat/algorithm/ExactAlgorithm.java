package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Result;
import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExactAlgorithm extends SetCoverAlgorithm {

    ExactAlgorithm(Universe universe, List<Set> sets) {
        super(universe, sets);
    }

    @Override
    public void solve() {
        int size = sets.size();
        List<Result> resultList = new ArrayList<>();
        for (int i = 0; i < (1 << size); i++) {
            Result result = new Result();

            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    result.addSet(sets.get(j));
                }
            }

            if (!result.isEmpty()) {
                resultList.add(result);
            }
        }
        results = findBestResults(filterByUniverseCoverage(resultList));
    }

    private List<Result> filterByUniverseCoverage(List<Result> results) {
        return results.stream()
                .filter(u -> u.coversUniverse(universe))
                .collect(Collectors.toList());
    }

    private List<Result> findBestResults(List<Result> results) {
        int min = results.stream()
                .min(Comparator.comparingInt(u -> u.getSets().size()))
                .orElseThrow(() -> new UniverseCoverageException(ERROR_MSG))
                .getSets().size();

        return results.stream()
                .filter(u -> u.getSets().size() == min)
                .collect(Collectors.toList());
    }
}
