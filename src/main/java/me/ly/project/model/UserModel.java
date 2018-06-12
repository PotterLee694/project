package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author LiYan
 * @date 2018/4/24 0:16
 */
@Data
@Accessors(chain = true)
public class UserModel {
    private Long id;
    private Long stuNo;
    private Integer userType;
    private String userName;
    private String iconUrl;

}
