package com.parkour.foundcrawler.controller;

import com.parkour.foundcrawler.entity.CommonResult;
import com.parkour.foundcrawler.entity.Found;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author parkour
 */
@RestController
@Slf4j
public class CustomerFoundController {

    @Resource
    RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://localhost:8001";

    @GetMapping(value = "/consumer/found/insertFound")
    public CommonResult insertFound(Found found) {
        return restTemplate.postForObject(PAYMENT_URL + "/provider/found/insertFound", found, CommonResult.class);
    }


    @GetMapping(value = "/consumer/found/selectFoundByFoundCode/{foundCode}")
    public CommonResult selectFoundByFoundCode(@PathVariable("foundCode") String foundCode) {
        return restTemplate.getForObject(PAYMENT_URL + "/provider/found/selectFoundByFoundCode/" + foundCode, CommonResult.class);
    }

}
