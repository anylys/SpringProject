package com.anyly.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot 发布dubbo服务
 * @author lishengrong
 */
@ImportResource(locations = "classpath:mybatis-config.xml")
@EnableTransactionManagement
@SpringBootApplication
@EnableDubbo
public class SysApplicationBoot {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SysApplicationBoot.class)
                //非web容器
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
