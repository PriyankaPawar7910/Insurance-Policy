package com.insurancepolicy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
/**
 * @author priypawa

 *
 */
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class PolicyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyServiceApplication.class, args);
	}


}
