package pl.edu.wat;

import pl.edu.wat.algorithm.AlgorithmManager;

public class AppRunner {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("You must pass data argument");
        }
        AlgorithmManager algorithmManager = new AlgorithmManager(Data.valueOf(String.valueOf(args[0]).toUpperCase()));
        algorithmManager.run();
    }
}
