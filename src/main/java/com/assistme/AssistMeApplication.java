package com.assistme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.assistme.models"})
public class AssistMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistMeApplication.class, args);
	}

}
