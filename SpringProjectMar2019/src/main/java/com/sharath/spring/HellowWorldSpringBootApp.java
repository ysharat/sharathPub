package com.sharath.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebSecurity
@SpringBootApplication
public class HellowWorldSpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(HellowWorldSpringBootApp.class, args);
	}
}
