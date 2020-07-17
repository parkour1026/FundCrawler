package com.parkour.fundcrawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author com.parkour
 * 基金表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fund implements Serializable {

    private Long id;
    private String fundcode;
    private String fundname;

    public Fund(String fundcode, String fundname) {
        this.fundcode = fundcode;
        this.fundname = fundname;
    }
}
