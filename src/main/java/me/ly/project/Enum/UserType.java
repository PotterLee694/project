package me.ly.project.Enum;

/**
 * @author LiYan
 * @date 2018/4/24 0:19
 */

public enum UserType{
    STUDENT(0),
    TEACHER(1)
    ;

    private Integer value;
    UserType(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
