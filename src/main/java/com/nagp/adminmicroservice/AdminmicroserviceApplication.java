package com.nagp.adminmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminmicroserviceApplication.class, args);
	}

}
