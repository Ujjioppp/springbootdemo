package com.sb.sbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan({"com.sb.sbdemo.dao"})
@ComponentScan(basePackages = "com.sb.sbdemo")
@EnableAutoConfiguration
public class SbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbdemoApplication.class, args);
    }
}
