package com.sample.sample;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@EnableCaching
@SpringBootApplication
public class SampleApplication {

	@Value("${allowed-origin-patterns}")
	String[] patterns;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOriginPatterns(patterns).exposedHeaders("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "POST", "OPTIONS");
			}
		};
	}
}
