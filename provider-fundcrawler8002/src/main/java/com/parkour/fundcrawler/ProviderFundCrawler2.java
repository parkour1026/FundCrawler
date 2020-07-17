package com.parkour.fundcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author com.parkour
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderFundCrawler2 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderFundCrawler2.class, args);
    }
}