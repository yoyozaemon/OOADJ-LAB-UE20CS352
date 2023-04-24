package com.filesharingsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.filesharingsystem.controller"})
@ImportResource("classpath:/spring/spring-config.xml")
public class filesharingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(filesharingsystemApplication.class, args);
    }

}
