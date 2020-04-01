package com.parkour.foundcrawler.dao;

import com.parkour.foundcrawler.entity.Found;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author com.parkour
 */
@Mapper
public interface FoundDao {

    /**
     * 插入一条基金的方法
     *
     * @param found 要插入的基金对象
     * @return 生成的主键
     */
    int insertFound(Found found);

    /**
     * 根据基金代码查询基金信息
     *
     * @param foundCode 基金代码
     * @return 找到的基金对象
     */
    Found selectFoundByFoundCode(@Param("foundCode") String foundCode);

}
