package com.lexartlabs.backendtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.lexartlabs.backendtest.repository"})
public class BackendTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendTestApplication.class, args);
    }

}
