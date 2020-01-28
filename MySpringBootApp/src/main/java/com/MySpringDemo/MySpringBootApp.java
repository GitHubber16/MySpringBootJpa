package com.MySpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.MySpringDem0.Repository")
@SpringBootApplication

public class MySpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApp.class, args);
	}

}
