package com.yzc.cloud.result;

/**
 * 统一返回码
 * SanZ
 */

public enum ResultCode implements ResultEnumerable{
    SUCCESS(200, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    VALIDATE_NULL(1003, "参数为空"),

    INEXISTENCE_DATA(1004, "不存在数据"),

    ERROR(500, "未知错误"),

    EXIST(501,"数据已存在");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

}