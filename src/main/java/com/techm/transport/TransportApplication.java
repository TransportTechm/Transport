package com.techm.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
//@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class TransportApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransportApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("Transport application has started");
		SpringApplication.run(TransportApplication.class, args);
	}

	@Bean
	public SimpleCORSFilter corsFilter(){
		return new SimpleCORSFilter();
	}
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}