package com.example.provider;

import com.netflix.discovery.shared.transport.jersey.AbstractJerseyEurekaHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientProviderApplication {//AbstractJerseyEurekaHttpClient

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderApplication.class, args);
	}

}
