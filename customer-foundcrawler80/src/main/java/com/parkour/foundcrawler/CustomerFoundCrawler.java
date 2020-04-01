package com.parkour.foundcrawler;

import com.parkour.foundcrawler.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author com.parkour
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-FOUNDCRAWLER", configuration = MyselfRule.class)
public class CustomerFoundCrawler {
    public static void main(String[] args) {
        SpringApplication.run(CustomerFoundCrawler.class, args);
    }
}