package com.zyb.crud.entity.enums;

import java.util.Arrays;


/**
 * @author ZhangYuBiao
 */

public enum CodeEnum {
 
    UN_LOGIN(40001, "登录信息失效，请登录"),
    SUCCESS(0, "请求成功"),
    FAILED(-1, "请求失败"),
    ENTRUST_NON(9999, "委托不存在"),
    SERVER_EXCEPTION(10000, "服务器异常，请重试。"),
    UNKNOWN_USERNAME(10001, "用户不存在"),
    ERROR_PASSWORD(10002, "密码不正确"),

    ;


    private int code;

    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static CodeEnum fromErrorMsg(String msg) {
        return Arrays.stream(CodeEnum.values()).filter(enumCode ->
                msg.equals(enumCode.getMsg())
        ).findAny().orElse(null);

    }
}