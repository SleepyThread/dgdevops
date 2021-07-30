package me.sleepythread.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OSImage {

    CENTOS("centos-8-x64");

    private final String imageId;
}
