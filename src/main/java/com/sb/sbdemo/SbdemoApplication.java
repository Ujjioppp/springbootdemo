package com.sb.sbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@MapperScan({"com.sb.sbdemo.dao"})
@ComponentScan(basePackages = "com.sb.sbdemo")
@EnableAutoConfiguration
@EnableSwagger2
public class SbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbdemoApplication.class, args);
    }
}
