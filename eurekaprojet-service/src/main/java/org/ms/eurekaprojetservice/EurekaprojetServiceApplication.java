package org.ms.eurekaprojetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaprojetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaprojetServiceApplication.class, args);
	}

}
