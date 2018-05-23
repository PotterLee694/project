package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author LiYan
 * @date 2018/4/24 1:06
 */
@Data
@Accessors(chain = true)
public class UserAccountModel {
    private Long id;
    private Long stuNo;
    private String password;
    private Integer userType;

}
