package com.anyly;
import com.anyly.config.mybatis.DataSourceJTAOrderConfig;
import com.anyly.config.mybatis.DataSourceJTAUserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author lishengrong
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.anyly.controller",
        "com.anyly.service.*",
        "com.anyly.config.mybatis",
})
@Import({
        DataSourceJTAOrderConfig.class,
        DataSourceJTAUserConfig.class
})
public class JTAApplicationBoot {
    public static void main(String[] args) {
        SpringApplication.run(JTAApplicationBoot.class, args);
    }

}