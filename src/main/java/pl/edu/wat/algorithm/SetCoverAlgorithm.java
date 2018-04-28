package pl.edu.wat.algorithm;

import pl.edu.wat.algorithm.model.Result;
import pl.edu.wat.algorithm.model.Set;
import pl.edu.wat.algorithm.model.Universe;

import java.util.List;

public abstract class SetCoverAlgorithm {

    protected static final String ERROR_MSG = "Universe cannot be covered with given sets";

    protected final Universe universe;
    protected final List<Set> sets;

    protected List<Result> results;
    protected Long time;

    protected SetCoverAlgorithm(Universe universe, List<Set> sets) {
        this.universe = universe;
        this.sets = sets;
    }

    public void run() {
        start();
        solve();
        finish();
    }

    protected abstract void solve();

    private void start() {
        System.out.println(String.format("Starting %s", getClass().getSimpleName()));
        time = System.currentTimeMillis();
    }

    private void finish() {
        time = System.currentTimeMillis() - time;
        results.forEach(
                r -> System.out.println(
                        String.format("Solution found: %s | number of subsets: %d", r, r.getSets().size())));
        System.out.println(String.format("Finishing %s. Done in %d millis.", getClass().getSimpleName(), time));
    }
}
