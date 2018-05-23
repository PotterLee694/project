package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TemplateModel {
    private Long id;
    private Long owner;
    private String title;
    private String template;
}
