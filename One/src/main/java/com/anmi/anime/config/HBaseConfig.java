package com.anmi.anime.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangjue on 2017/9/22.
 */
@Component
@ConfigurationProperties(prefix = "spring.hbase")
public class HBaseConfig {
    private String hbaseMaster;
    private String zooQuorum;
    private String zooPort;

    public String getHbaseMaster() {
        return hbaseMaster;
    }

    public void setHbaseMaster(String hbaseMaster) {
        this.hbaseMaster = hbaseMaster;
    }

    public String getZooQuorum() {
        return zooQuorum;
    }

    public void setZooQuorum(String zooQuorum) {
        this.zooQuorum = zooQuorum;
    }

    public String getZooPort() {
        return zooPort;
    }

    public void setZooPort(String zooPort) {
        this.zooPort = zooPort;
    }
}
