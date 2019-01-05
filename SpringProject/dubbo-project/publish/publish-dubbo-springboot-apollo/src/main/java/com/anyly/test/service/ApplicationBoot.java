package com.anyly.test.service;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot 发布dubbo服务
 * @author lishengrong
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.anyly.test")
@EnableDubbo
public class ApplicationBoot {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationBoot.class)
                //非web容器
                .web(WebApplicationType.NONE)
                .run(args);
    }
}