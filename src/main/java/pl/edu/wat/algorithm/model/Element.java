package pl.edu.wat.algorithm.model;

public class Element {

    private final Integer number;

    Element(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
