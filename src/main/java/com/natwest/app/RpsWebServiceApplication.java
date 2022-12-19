package com.natwest.app;

import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpsWebServiceApplication {

	@Bean
	public Random getRandom() {
		return new Random();
	}

	public static void main(String[] args) {
		SpringApplication.run(RpsWebServiceApplication.class, args);
	}

}
