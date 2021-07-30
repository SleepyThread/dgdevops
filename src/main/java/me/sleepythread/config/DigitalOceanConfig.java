package me.sleepythread.config;

import lombok.Data;

import java.util.List;

@Data
public class DigitalOceanConfig {

    private final String providerGroup;
    private final String token;
    private final String image;
    private final String region;
    private final List<String> sshKeyIds;


}
