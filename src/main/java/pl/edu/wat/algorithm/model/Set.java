package pl.edu.wat.algorithm.model;

import java.util.List;
import java.util.stream.Collectors;

public class Set {

    private Integer id;
    private List<Element> elements;

    private static Integer AMOUNT = 0;

    public static List<Set> create(List<List<Integer>> subsets) {
        return subsets.stream()
                .map(e -> {
                    Set set = new Set();
                    set.setId(++AMOUNT);
                    set.setElements(toElement(e));
                    return set;
                }).collect(Collectors.toList());
    }

    private static List<Element> toElement(List<Integer> numbers) {
        return numbers.stream()
                .map(ElementFactory::getElement)
                .collect(Collectors.toList());
    }

    private Set() {
    }

    Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public List<Element> getElements() {
        return elements;
    }

    private void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Set " + id + ": " + elements;
    }
}
