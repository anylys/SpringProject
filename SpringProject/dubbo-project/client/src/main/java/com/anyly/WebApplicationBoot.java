package com.anyly;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lishengrong
 * 调用服务
 */
@SpringBootApplication
@ImportResource(locations = "classpath:consumer.xml")
public class WebApplicationBoot {

    public static void main(String[] args){
        SpringApplication.run(WebApplicationBoot.class, args);
    }
}
