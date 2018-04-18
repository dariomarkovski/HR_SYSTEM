package com.soa.hrSystem.vacations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VacationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationsApplication.class, args);
	}
}
