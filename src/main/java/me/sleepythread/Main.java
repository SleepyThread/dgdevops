package me.sleepythread;

import me.sleepythread.config.DgNetwork;
import me.sleepythread.config.DigitalOceanConfig;

import com.hashicorp.cdktf.App;

public class Main {

    public static final String DGCONFIG_FILENAME = "dgconfig.json";
    public static final String NETWORK_FILE_NAME = "network.json";

    public static void main(String[] args) {
        final App app = new App();
        String location = System.getProperty("user.dir");
        DigitalOceanConfig digitalOceanConfig = FileBuilder.buildDgConfig(location + "/" + DGCONFIG_FILENAME);
        DgNetwork network = FileBuilder.buildDgNetwork(location + "/" + NETWORK_FILE_NAME);
        System.out.println("Network ==> " + network);
        new NetworkBuilder(app, "dgdevops", network, digitalOceanConfig);

        app.synth();
    }
}