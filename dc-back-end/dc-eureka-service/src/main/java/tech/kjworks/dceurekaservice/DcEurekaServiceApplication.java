package tech.kjworks.dceurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DcEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcEurekaServiceApplication.class, args);
	}

}
