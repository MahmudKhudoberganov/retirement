package com.luxoft.retirement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RetirementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetirementApplication.class, args);
	}

}
