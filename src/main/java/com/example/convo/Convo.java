package com.example.convo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo.models"})
@Configuration
@ComponentScan({ "com.example.*"})
@EnableJpaRepositories("com.example.demo.repositories")



public class Convo {

	public static void main(String[] args) {
		SpringApplication.run(Convo.class, args);
	}

}
