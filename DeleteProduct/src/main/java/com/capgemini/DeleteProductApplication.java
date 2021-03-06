package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeleteProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteProductApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate resttemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
	

}
