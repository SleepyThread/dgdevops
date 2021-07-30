package me.sleepythread.config;

import imports.digitalocean.DigitaloceanProvider;
import imports.digitalocean.Droplet;
import imports.digitalocean.Vpc;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DgNetworkOutput {

    private final DigitaloceanProvider provider;
    private final Vpc vpc;
    private final Map<String, List<Droplet>> dropletGroupOutputList;
}
