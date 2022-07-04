package com.yzc.cloud.feign;



import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;




/**
 * @Description
 * @Author JessionZhang
 * @Date 2022年5月26日
 */
@Component
@FeignClient(name = "cloud-order",path = "/")
public interface OrderFeign {
    /**
     * get orders && order_products
     * @return
     */
    @PostMapping("/cloudOrder")
    JSONArray returnList();



}
