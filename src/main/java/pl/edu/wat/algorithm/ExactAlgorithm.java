package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Result;
import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;

import java.util.ArrayList;
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

            if (result.coversUniverse(universe)) {
                resultList.add(result);
            }
        }
        results = findBestResults(resultList);
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
