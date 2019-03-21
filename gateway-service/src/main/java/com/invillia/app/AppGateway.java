package com.invillia.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * App Main - Gateway Service
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class AppGateway {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AppGateway.class).web(WebApplicationType.SERVLET).run(args);
	}

}
