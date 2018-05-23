package me.ly.project.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.Enum.AppError;

/**
 * @author LiYan
 * @date 2018/4/25 11:52
 */
@Data
@Accessors(chain = true)

public class BaseRes {
    final static String SUCCESS = "0000";

    private String code = SUCCESS;
    private String message = "";
    private String content = "";
    private Boolean success = true;


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

}
