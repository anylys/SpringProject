package com.anyly.test.config;

import com.alibaba.dubbo.config.RegistryConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public DubboConfig dubboConfig() {
        return new DubboConfig();
    }
    @Bean
    public RegistryConfig registryConfig(@Qualifier("dubboConfig") DubboConfig config) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(config.gistryAddress);
        registryConfig.setProtocol(config.registryProtocol);
        registryConfig.setClient("curator");
        return registryConfig;
    }
}