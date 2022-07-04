package com.yzc.cloud.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


/**
 * 统一返回体
 * SanZ
 */
@Data
@AllArgsConstructor
public class ResultObject<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    //把构造方法私有
    private ResultObject() {
    }

    // 增加方法，参数类型为 ResultEnumerable 接口
    public static <T> ResultObject<T> success(ResultEnumerable resultEnum) {
        return new ResultObject<>(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static <T> ResultObject<T> success(T data) {
        return new ResultObject<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    // 增加方法，参数类型为 ResultEnumerable 接口
    public static <T> ResultObject<T> success(ResultEnumerable resultEnum, T data) {
        return new ResultObject<>(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    //失败静态方法
    public static <T> ResultObject<T> error() {
        ResultObject<T> r = new ResultObject<>();
        r.setCode(500);
        r.setMessage("失败");
        return r;
    }

    public static <T> ResultObject<T> error(ResultEnumerable resultEnum) {
        return new ResultObject<>(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static <T> ResultObject<T> error(Integer code, String message) {
        return new ResultObject<>(code, message);
    }

    public ResultObject<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultObject<T> code(Integer code) {
        this.setCode(code);
        return this;
    }


    public ResultObject(int code) {
        this.code = code;
        this.message = "success";
        this.data = null;
    }

    public ResultObject(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResultObject(int code, T data) {
        this.code = code;
        this.message = "success";
        this.data = data;
    }


    public ResultObject(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
