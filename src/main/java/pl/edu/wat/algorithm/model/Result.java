package pl.edu.wat.algorithm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private List<Set> sets = new ArrayList<>();

    public void addSet(Set set) {
        sets.add(set);
    }

    public boolean isEmpty() {
        return sets.isEmpty();
    }

    public boolean coversUniverse(Universe universe) {
        List<Element> elements = sets.stream()
                .flatMap(s -> s.getElements().stream())
                .collect(Collectors.toList());

        return elements.containsAll(universe.getElements());
    }

    public List<Set> getSets() {
        return sets;
    }

    @Override
    public String toString() {
        List<String> setNames = sets.stream()
                .map(s -> "Set " + s.getId())
                .collect(Collectors.toList());
        return String.join(", ", setNames);
    }
}
