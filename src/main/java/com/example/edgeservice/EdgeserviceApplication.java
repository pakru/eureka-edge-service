package com.example.edgeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EdgeserviceApplication {

    private static Logger logger = LoggerFactory.getLogger(EdgeserviceApplication.class);

    public static void main(String[] args) {
        logger.info("Starting app");
        SpringApplication.run(EdgeserviceApplication.class, args);
        logger.info("App Started");
    }

}

