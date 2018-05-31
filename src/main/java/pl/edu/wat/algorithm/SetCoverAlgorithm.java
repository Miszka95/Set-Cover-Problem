package pl.edu.wat.algorithm;

import pl.edu.wat.Metrics;
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
    protected Long memory;
    private Long counter;

    protected SetCoverAlgorithm(Universe universe, List<Set> sets) {
        this.universe = universe;
        this.sets = sets;
    }

    public void run() {
        before();
        solve();
        after();
    }

    protected abstract void solve();

    private void before() {
        System.out.println(String.format("Starting %s", getClass().getSimpleName()));
        counter = 0L;
        memory = Metrics.getUsedMemory();
        time = System.currentTimeMillis();
    }

    private void after() {
        time = System.currentTimeMillis() - time;
        memory = Metrics.getUsedMemory() - memory;
        results.forEach(
                r -> System.out.println(
                        String.format("Solution found: %s | number of subsets: %d", r, r.getSets().size())));
        System.out.println(String.format("Finishing %s", getClass().getSimpleName()));
        System.out.println(String.format("Done in %d millis.", time));
        System.out.println(String.format("Used %d bytes of memory.", memory));
        System.out.println(String.format("Executed %d instructions", counter));
    }

    protected void count() {
        counter += 1;
    }

    protected void count(Long count) {
        counter += count;
    }
}
