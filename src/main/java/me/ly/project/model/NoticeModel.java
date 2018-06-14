package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NoticeModel {
    private Long id;
    private Long userId;
    private String type;
    private String content;
    private String checkTime;
    private String createStamp;
}
