package com.invillia.app;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/*
 * App Main - ProductService
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@SpringBootApplication
@ComponentScan({"com.invillia.controller", "com.invillia"})
@EntityScan("com.invillia.model")
@EnableJpaRepositories("com.invillia.repository")
@RibbonClients({
	@RibbonClient(name = "order-service"),
	@RibbonClient(name = "businness-service")
})
public class AppProduct {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@PostConstruct
    void init() {
      TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(AppProduct.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
