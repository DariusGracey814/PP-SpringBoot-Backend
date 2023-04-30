package com.planetpreserve.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);	
	}
	
	// Enable CORS to allow front end to connect to spring boot rest API
	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("*")
				.allowedOrigins("https://planet-preserve.web.app", "https://planet-preserve.firebaseapp.com"); 
			};
		};
	}
}


