package me.ly.project.model;

import me.ly.project.Enum.AppError;

/**
 * @author LiYan
 * @date 2018/4/25 11:52
 */
public class BaseRes {
    final static String SUCCESS = "0000";

    private String code = SUCCESS;
    private String message = "";
    private String content = "";
    private Boolean success = true;



    public String getCode() {
        return code;
    }

    public BaseRes setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseRes setMessage(String message) {
        this.message = message;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public BaseRes setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * 设置基本返回信息
     * @param code 默认"0000" 为成功
     * @param message
     * @return
     */
    public BaseRes setBaseRes(String code, String message) {
        this.code = code;
        this.message = message;
        if (!"0000".equals(code)) {
            this.success = false;
        }
        return this;
    }

    /**
     * 设置基本返回信息
     * @param appError 错误信息
     * @return
     */
    public BaseRes setBaseRes(AppError appError) {
        this.code = appError.getCode();
        this.message = appError.getMsg();
        if (!"0000".equals(this.code)) {
            this.success = false;
        }
        return this;
    }
     public String getContent() {
        return content;
    }

    public BaseRes setContent(String content) {
        this.content = content;
        return this;
    }

}
