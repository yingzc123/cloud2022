package com.yzc.cloud.exception;


import com.yzc.cloud.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SanZ
 * 自定义异常
 */
@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class YzcException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息

    public YzcException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
