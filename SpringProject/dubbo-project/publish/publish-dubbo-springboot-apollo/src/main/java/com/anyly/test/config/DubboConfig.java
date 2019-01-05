package com.anyly.test.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@EnableConfigurationProperties
public class DubboConfig {
    private Logger logger = LoggerFactory.getLogger(DubboConfig.class);
    @Value("${dubbo.registry.address}")
    public String gistryAddress;
    @Value("${dubbo.registry.protocol}")
    public String registryProtocol;

    public String getGistryAddress() {
        logger.info("======================"+gistryAddress);
        return gistryAddress;
    }

    public void setGistryAddress(String gistryAddress) {
        logger.info("======================"+gistryAddress);
        this.gistryAddress = gistryAddress;
    }

    public String getRegistryProtocol() {
        logger.info("======================"+gistryAddress);
        return registryProtocol;
    }

    public void setRegistryProtocol(String registryProtocol) {
        logger.info("======================"+registryProtocol);
        this.registryProtocol = registryProtocol;
    }
}
