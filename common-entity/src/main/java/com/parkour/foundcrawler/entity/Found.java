package com.parkour.foundcrawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author parkour
 * 基金表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Found implements Serializable {

    private Long id;
    private String foundcode;
    private String foundname;

    public Found(String foundcode, String foundname) {
        this.foundcode = foundcode;
        this.foundname = foundname;
    }
}
