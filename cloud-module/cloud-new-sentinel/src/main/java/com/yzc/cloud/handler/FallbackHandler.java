package com.yzc.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yzc.cloud.result.ResultObject;

/**
 * @author: SanZ
 * @DATE: 2022/7/5 17:19
 */
public class FallbackHandler {

    public static ResultObject resultObject() {
        return new ResultObject(555, "异常处理降级");
    }
}
