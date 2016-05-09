package com.sm.xblock.entity;

import com.sm.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by smplayer on 2016/5/3.
 */
@Entity
@Table(name = "sm_tb_key")
public class Key extends BaseEntity {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
