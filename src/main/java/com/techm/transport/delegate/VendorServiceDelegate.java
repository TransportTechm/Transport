package com.techm.transport.delegate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VendorServiceDelegate {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callFallbackMethod")
	public String callVendorServiceAndGetAllDrivers() {

		List<ServiceInstance> instances=discoveryClient.getInstances("VendorServiceT");
		ServiceInstance serviceInstance=instances.get(0);

		String baseUrl=serviceInstance.getUri().toString();
		baseUrl = baseUrl+"/1.0/drivers";
		String response=null;
		try{
			response=restTemplate.exchange(baseUrl,
					HttpMethod.GET, getHeaders(),String.class).getBody();
		}catch (Exception ex){
			System.out.println(ex);
		}

		System.out.println("Response Received as " + response + " -  " + new Date());

		return response;
	}

	@SuppressWarnings("unused")
	private String callFallbackMethod() {
		return "CIRCUIT_BREAKER_ENABLED";
	}

	private static HttpEntity<?> getHeaders() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
