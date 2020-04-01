package com.parkour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author com.parkour
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderFoundCrawler2 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderFoundCrawler2.class, args);
    }
}