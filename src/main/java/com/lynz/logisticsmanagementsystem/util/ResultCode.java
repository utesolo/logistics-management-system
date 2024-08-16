package com.lynz.logisticsmanagementsystem.util;

import lombok.Getter;

/**
 * @author lynz
 */

@Getter
public enum ResultCode {

    // 自定义枚举内容
    SUCCESS(200,"Success"),

    ERROR(-100, "Error"),

    ONLINE(200,"Online"),

    OFFLINE(200,"Offline");

    final private Integer code;
    final private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
