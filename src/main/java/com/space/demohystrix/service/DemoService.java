package com.space.demohystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class DemoService {

    private final RestTemplate restTemplate;
    public DemoService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "trustful")
    public String callNodeJSService() {
        URI uri = URI.create("http://localhost:3000/api/v1/getHelloWorld");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String trustful() {
        return "Service not response!";
    }
}
