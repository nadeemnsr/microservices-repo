package com.discovery.account.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceManagementApplication.class, args);
	}

}
