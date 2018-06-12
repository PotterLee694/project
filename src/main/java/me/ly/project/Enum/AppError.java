package me.ly.project.Enum;

/**
 * @author LiYan
 * @date 2018/5/5 10:37
 */
public enum AppError {

    LOGIN_FAILED("0001", "登录失败，学号或密码错误"),
    STUNO_ERROR("0002", "登录失败，无效的学号"),
    UPDATE_ERROR("0003", "修改失败"),





    SUCCESS("0000", "成功")
    ;

    private String code;
    private String msg;
    AppError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
