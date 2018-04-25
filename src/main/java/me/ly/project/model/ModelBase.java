package me.ly.project.model;

import lombok.Data;

/**
 * @author LiYan
 * @date 2018/4/25 11:52
 */
public class ModelBase {
    private String content;

    public String getContent() {
        return content;
    }

    public ModelBase setContent(String content) {
        this.content = content;
        return this;
    }
}
