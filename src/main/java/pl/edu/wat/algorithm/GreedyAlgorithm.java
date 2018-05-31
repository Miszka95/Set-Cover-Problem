package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Element;
import pl.edu.wat.algorithm.model.Result;
import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GreedyAlgorithm extends SetCoverAlgorithm {

    GreedyAlgorithm(Universe universe, List<Set> sets) {
        super(universe, sets);
    }

    @Override
    protected void solve() {
        Result result = new Result();
        List<Set> availableSets = new ArrayList<>(sets);

        do {
            Set mostEffectiveSet = findMostEffectiveSet(availableSets, result);
            result.addSet(mostEffectiveSet);
            availableSets.remove(mostEffectiveSet);
            count((long) 3);
        } while (!result.coversUniverse(universe));

        results = Collections.singletonList(result);
    }

    private Set findMostEffectiveSet(List<Set> sets, Result result) {
        List<Element> coveredElements = result.getSets().stream()
                .flatMap(e -> e.getElements().stream())
                .collect(Collectors.toList());

        count((long) sets.size());
        return sets.stream()
                .max(Comparator.comparingInt(s -> countNewElements(coveredElements, s.getElements())))
                .orElseThrow(() -> new UniverseCoverageException(ERROR_MSG));
    }

    private Integer countNewElements(List<Element> alreadyCovered, List<Element> setElements) {
        List<Element> setElementsCopy = new ArrayList<>(setElements);
        setElementsCopy.removeAll(alreadyCovered);
        return setElementsCopy.size();
    }
}
