package com.java.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.java.rest.keyvalue.service,com.java.rest.keyvalue.controller,com.java.rest.keyvalue.repository")
@EnableJpaRepositories(basePackages = "com.java.rest.keyvalue.repository")
@EnableJpaAuditing
@EntityScan(basePackages = "com.java.rest.keyvalue.model")
public class CyBaseTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(CyBaseTestApplication.class, args);
	}
}
