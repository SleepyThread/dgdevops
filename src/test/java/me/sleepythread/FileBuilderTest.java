package me.sleepythread;

import me.sleepythread.config.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileBuilderTest {

    @Test
    public void testConfigLoad() {
        String fileName = "dgconfig.json";
        String resource = getClass().getClassLoader().getResource(fileName).getPath();

        DigitalOceanConfig config = FileBuilder.buildDgConfig(resource);

        assertEquals("bc968a5caff2", config.getToken());
        assertEquals("digitalOceanProvider", config.getProviderGroup());
        assertEquals("centos-8-x64", config.getImage());
        assertEquals("lon1", config.getRegion());
        assertEquals(Arrays.asList("309"), config.getSshKeyIds());
    }

    @Test
    public void testDgNetworkLoad() {
        String fileName = "network1.json";
        String resource = getClass().getClassLoader().getResource(fileName).getPath();

        DgNetwork config = FileBuilder.buildDgNetwork(resource);

        assertEquals("plan", config.getPrivateVpc());
        assertEquals(Arrays.asList(new DropletGroup("web", 3, DropletSize.TINY, OSImage.CENTOS)),config.getDropletGroups());
    }



}