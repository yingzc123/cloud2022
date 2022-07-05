package com.yzc.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yzc.cloud.result.ResultObject;


public class SentinelHandler {

    public static ResultObject resultObject(BlockException blockException) {
        return new ResultObject(444, "你已经被流控");
    }

}
