package com.parkour.foundcrawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author parkour
 * 传递给前端的公共实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    /**
     * 消息代码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 具体的数据
     */
    private T data;

    /**
     * 用于生成返回data为空的构造方法
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
