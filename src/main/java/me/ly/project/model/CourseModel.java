package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CourseModel {
    private Long id;
    private Long owner;
    private String title;
    private String description;
    private String teachers;
    private String courseTime;
    private Boolean courseOver;

    private String infoPdf;
    private String prePdf;
    private String preVideo;
    private Boolean liked;
}
