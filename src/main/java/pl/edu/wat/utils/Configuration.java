package pl.edu.wat.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Configuration {

    private List<Integer> universe;
    private List<List<Integer>> sets;

    private static final String CONFIG_FILE = "configuration.yml";
    private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();
    private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());

    public static Configuration load() {
        try (InputStream in = CLASS_LOADER.getResourceAsStream(CONFIG_FILE)) {
            return MAPPER.readValue(in, Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Configuration();
    }

    public List<Integer> getUniverse() {
        return universe;
    }

    public List<List<Integer>> getSets() {
        return sets;
    }
}
