package pl.edu.wat.utils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Generator {

    private static final Integer SIZE_OF_UNIVERSE = 22;
    private static final Integer NUMBER_OF_SETS = 22;
    private static final Integer LEVEL_OF_COVERAGE = Coverage.MEDIUM.getLevel();

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private List<Integer> universe;
    private List<List<Integer>> sets;

    public static Generator generate() {
        Generator generator = new Generator();
        generator.generateUniverse();
        generator.generateSets(generator.getUniverse());
        return generator;
    }

    private void generateUniverse() {
        Set<Integer> universe = new HashSet<>();
        while (universe.size() < SIZE_OF_UNIVERSE) {
            universe.add(random.nextInt(SIZE_OF_UNIVERSE * 5));
        }
        this.universe = new ArrayList<>(universe);
    }

    private void generateSets(List<Integer> universe) {
        Set<Set<Integer>> sets = new HashSet<>();

        while (sets.size() < NUMBER_OF_SETS) {
            sets.add(generateSingleSet(universe));
        }
        this.sets = sets.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    private Set<Integer> generateSingleSet(List<Integer> universe) {
        List<Integer> copy = new ArrayList<>(universe);
        Set<Integer> set = new HashSet<>();
        int size = random.nextInt(1, SIZE_OF_UNIVERSE) / LEVEL_OF_COVERAGE;
        while (set.size() < size) {
            set.add(copy.remove(random.nextInt(0, copy.size())));
        }
        return set;
    }

    public List<Integer> getUniverse() {
        return universe;
    }

    public List<List<Integer>> getSets() {
        return sets;
    }
}
