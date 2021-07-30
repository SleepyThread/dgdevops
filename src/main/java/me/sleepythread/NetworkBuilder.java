package me.sleepythread;

import com.hashicorp.cdktf.TerraformStack;
import imports.digitalocean.DigitaloceanProvider;
import imports.digitalocean.Droplet;
import imports.digitalocean.Vpc;
import lombok.Getter;
import me.sleepythread.config.DgNetwork;
import me.sleepythread.config.DgNetworkOutput;
import me.sleepythread.config.DigitalOceanConfig;
import me.sleepythread.config.DropletGroup;
import software.constructs.Construct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class NetworkBuilder extends TerraformStack {

    private final DgNetworkOutput dgNetworkOutput;

    public NetworkBuilder(Construct scope, String id, DgNetwork dgNetwork, DigitalOceanConfig config) {
        super(scope, id);

        DigitaloceanProvider provider = DigitaloceanProvider.Builder.create(this, config.getProviderGroup())
                .token(config.getToken()).build();

        String privateVpc = dgNetwork.getPrivateVpc();
        Vpc vpc = Vpc.Builder.create(this, privateVpc)
                .region(config.getRegion())
                .name(privateVpc)
                .build();

        HashMap<String, List<Droplet>> map = new HashMap<>();
        for (DropletGroup dropletGroup: dgNetwork.getDropletGroups()) {
            ArrayList<Droplet> droplets = new ArrayList<>();
            for (int i = 1; i <= dropletGroup.getNumDroplet(); i++) {
                String dropletName = dropletGroup.getGroupName() + i + ".plan";
                Droplet droplet = Droplet.Builder.create(this, dropletName)
                        .image(dropletGroup.getOsImage().getImageId())
                        .name(dropletName)
                        .region(config.getRegion())
                        .size(dropletGroup.getDropletSize().getId())
                        .privateNetworking(true)
                        .monitoring(true)
                        .provider(provider)
                        .vpcUuid(vpc.getId())
                        .sshKeys(config.getSshKeyIds())
                        .provider(provider)
                        .build();
                droplets.add(droplet);
            }
        }
        this.dgNetworkOutput = new DgNetworkOutput(provider, vpc, map);
    }
}
