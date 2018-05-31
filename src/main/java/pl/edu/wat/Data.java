package pl.edu.wat;

public enum Data {
    RANDOM("random"),
    FILE("file");

    private String type;

    Data(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
