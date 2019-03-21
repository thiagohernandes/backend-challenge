package com.invilia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * App Main - Eureka Server
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@SpringBootApplication
@EnableEurekaServer
public class AppEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(AppEurekaServer.class, args);
	}

}
