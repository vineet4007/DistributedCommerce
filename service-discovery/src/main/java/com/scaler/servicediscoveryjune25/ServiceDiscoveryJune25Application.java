package com.scaler.servicediscoveryjune25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryJune25Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryJune25Application.class, args);
    }

}
