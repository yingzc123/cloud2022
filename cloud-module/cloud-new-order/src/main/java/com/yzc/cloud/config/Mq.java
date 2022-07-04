package com.yzc.cloud.config;

import com.yzc.cloud.feign.proxyFeign.ProxyUserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: SanZ
 * @DATE: 2022/6/28 15:20
 */

@Slf4j
@Component
public class Mq {

    @Autowired
    private ProxyUserFeign proxyUserFeign;


    @RabbitListener(queues = "order_succeed_queue")
    public void userOrderSucceedAfter(String msg) {
      /*  String resultObject = proxyUserFeign.returnString();
        System.out.println("user:"+resultObject);*/

        log.info("支付成功消费队列:{}", msg);
    }

}
