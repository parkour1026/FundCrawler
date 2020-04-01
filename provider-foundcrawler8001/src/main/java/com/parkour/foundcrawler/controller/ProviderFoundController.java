package com.parkour.foundcrawler.controller;

import com.parkour.foundcrawler.entity.CommonResult;
import com.parkour.foundcrawler.entity.Found;
import com.parkour.foundcrawler.service.FoundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author com.parkour
 */
@RestController
@Slf4j
public class ProviderFoundController {

    @Resource
    private FoundService foundService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/provider/found/insertFound")
    public CommonResult insertFound(@RequestBody Found found) {
        int i = foundService.insertFound(found);

        if (i > 0) {
            log.info("插入基金成功!");
            return new CommonResult<>(100, "插入成功,serverport:" + serverPort, i);
        } else {
            log.info("插入基金失败!");
            return new CommonResult<>(-100, "插入失败,serverport:" + serverPort, null);
        }
    }


    @GetMapping(value = "/provider/found/selectFoundByFoundCode/{foundCode}")
    public CommonResult selectFoundByFoundCode(@PathVariable("foundCode") String foundCode) {
        Found found = foundService.selectFoundByFoundCode(foundCode);

        if (found != null) {
            log.info("根据基金编码查询基金成功!");
            return new CommonResult<>(200, "查询成功!,serverport:" + serverPort, found);
        } else {
            log.info("根据基金编码查询基金失败!");
            return new CommonResult<>(-200, "基金代码,serverport:" + serverPort + foundCode + "不正确!", found);
        }

    }

    @GetMapping(value = "/provider/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        log.info("获取eureka中注册的所有服务");
        for (String service : services) {
            log.info(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-FOUNDCRAWLER");

        log.info("获取eureka中指定服务名下的所有实例");
        for (ServiceInstance instance : instances) {
            log.info(instance.getUri() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getInstanceId());
        }

        return this.discoveryClient;
    }

}
