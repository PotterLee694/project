package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommentModel {
    private Long id;
    private Long reportId;
    private Long userId;
    private Integer score;
    private Long zan;
    private String comment;
    private String createStamp;

    private String userName;
    private String iconUrl;
}
