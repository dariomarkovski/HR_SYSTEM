package com.soa.hrSystem.devices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DevicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevicesApplication.class, args);
	}
}
