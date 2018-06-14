package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReportModel {
    private Long id;
    private Long courseId;
    private Long templateId;
    private Long userId;
    private String answer;
    private String createStamp;
}
