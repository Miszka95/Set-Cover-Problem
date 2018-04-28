package pl.edu.wat.algorithm.model;

import pl.edu.wat.utils.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class Universe {

    private List<Element> elements;

    public static Universe fromConfiguration(Configuration configuration) {
        Universe universe = new Universe();
        universe.setElements(
                configuration.getUniverse().stream()
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
