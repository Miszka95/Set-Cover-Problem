package pl.edu.wat;

import pl.edu.wat.algorithm.AlgorithmManager;

public class AppRunner {

    public static void main(String[] args) {
        String data = "file";
        AlgorithmManager algorithmManager = new AlgorithmManager(Data.valueOf(data.toUpperCase()));
        algorithmManager.run();
    }
}
