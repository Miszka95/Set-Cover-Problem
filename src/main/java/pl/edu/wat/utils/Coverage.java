package pl.edu.wat.utils;

public enum Coverage {
    EASY(1),
    MEDIUM(2),
    HARD(3),
    VERY_HARD(4);

    private final Integer level;

    Coverage(int level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
