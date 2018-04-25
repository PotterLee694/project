package me.ly.project.model;

/**
 * @author LiYan
 * @date 2018/4/24 1:06
 */
public class UserAccoutModel {
    private Long id;
    private Long stuNo;
    private String password;

    public Long getId() {
        return id;
    }

    public UserAccoutModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStuNo() {
        return stuNo;
    }

    public UserAccoutModel setStuNo(Long stuNo) {
        this.stuNo = stuNo;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccoutModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
