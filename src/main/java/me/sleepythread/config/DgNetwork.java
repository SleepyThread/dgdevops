package me.sleepythread.config;

import lombok.Data;

import java.util.List;

@Data
public class DgNetwork {

    private final String privateVpc;
    private final List<DropletGroup> dropletGroups;

}
