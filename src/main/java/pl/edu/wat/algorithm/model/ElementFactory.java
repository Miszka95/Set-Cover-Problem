package pl.edu.wat.algorithm.model;

import java.util.HashMap;
import java.util.Map;

class ElementFactory {

    private static final Map<Integer, Element> elements = new HashMap<>();

    static Element getElement(Integer number) {
        Element element = elements.get(number);

        if (element == null) {
            element = new Element(number);
            elements.put(number, element);
        }
        return element;
    }

    private ElementFactory() {
    }
}
