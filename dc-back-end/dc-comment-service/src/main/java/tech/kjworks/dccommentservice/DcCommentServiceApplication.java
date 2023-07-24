package tech.kjworks.dccommentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableDiscoveryClient
@EnableFeignClients
public class DcCommentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DcCommentServiceApplication.class, args);
	}
}
