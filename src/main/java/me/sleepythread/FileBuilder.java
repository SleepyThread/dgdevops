package me.sleepythread;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import me.sleepythread.config.DgNetwork;
import me.sleepythread.config.DigitalOceanConfig;

import java.io.FileReader;

public class FileBuilder {

    public static DigitalOceanConfig buildDgConfig(String location) {
        try {
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new FileReader(location));
            return gson.fromJson(jsonReader, new TypeToken<DigitalOceanConfig>(){}.getType());
        } catch (Exception e) {
          throw new RuntimeException("Unable to parse Config at location " + location, e);
        }
    }

    public static DgNetwork buildDgNetwork(String location) {
        try {
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new FileReader(location));
            return gson.fromJson(jsonReader, new TypeToken<DgNetwork>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Unable to parse Config at location " + location, e);
        }
    }
}
