package me.sleepythread.config;

import lombok.Data;

@Data
public class DropletGroup {

    private final String groupName;
    private final Integer numDroplet;
    private final DropletSize dropletSize;
    private final OSImage osImage;
}
