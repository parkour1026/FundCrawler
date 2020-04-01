package com.parkour.foundcrawler.controller;

import com.parkour.foundcrawler.entity.CommonResult;
import com.parkour.foundcrawler.entity.Found;
import com.parkour.foundcrawler.service.FoundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author com.parkour
 */
@RestController
@Slf4j
public class ProviderFoundController {

    @Resource
    private FoundService foundService;

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

}