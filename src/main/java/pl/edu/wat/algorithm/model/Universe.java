package pl.edu.wat.algorithm.model;

import java.util.List;
import java.util.stream.Collectors;

public class Universe {

    private List<Element> elements;

    public static Universe create(List<Integer> elements) {
        Universe universe = new Universe();
        universe.setElements(
                elements.stream()
                        .map(ElementFactory::getElement)
                        .collect(Collectors.toList()));
        return universe;
    }

    private Universe() {
    }

    List<Element> getElements() {
        return elements;
    }

    private void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Universe: " + elements;
    }
}
