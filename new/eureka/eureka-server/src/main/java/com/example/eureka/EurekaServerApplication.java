package com.example.eureka;

import com.netflix.discovery.shared.transport.jersey.AbstractJerseyEurekaHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {//AbstractJerseyEurekaHttpClient

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
