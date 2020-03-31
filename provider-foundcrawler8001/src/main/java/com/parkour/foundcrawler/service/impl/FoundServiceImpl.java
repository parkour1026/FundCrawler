package com.parkour.foundcrawler.service.impl;

import com.parkour.foundcrawler.dao.FoundDao;
import com.parkour.foundcrawler.entity.Found;
import com.parkour.foundcrawler.service.FoundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author parkour
 */
@Service
public class FoundServiceImpl implements FoundService {

    @Resource
    private FoundDao foundDao;

    @Override
    public int insertFound(Found found) {
        return foundDao.insertFound(found);
    }

    @Override
    public Found selectFoundByFoundCode(String foundCode) {
        return foundDao.selectFoundByFoundCode(foundCode);
    }
}
