package me.sleepythread.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DropletSize {

    TINY("s-1vcpu-1gb"),
    SMALL("s-1vcpu-2gb"),
    MEDIUM("s-2vcpu-2gb"),
    LARGE("s-2vcpu-4gb");

    private final String id;

}
