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

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStuNo() {
        return stuNo;
    }

    public UserModel setStuNo(Long stuNo) {
        this.stuNo = stuNo;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public UserModel setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", stuNo=" + stuNo +
                ", userType=" + userType +
                ", userName='" + userName + '\'' +
                '}';
    }
}
