package com.yzc.cloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: SanZ
 * @DATE: 2022/6/28 15:17
 */
@Configuration
public class RabbitMqConfig {


    /******/
    @Bean
    public Queue orderSucceed(){return new Queue("order_succeed_queue");}
    @Bean
    FanoutExchange orderSucceedExchange(){return new FanoutExchange("order_succeed");}
    @Bean
    Binding bindingOrderSucceedExchangeAndOrderSucceed(Queue orderSucceed, FanoutExchange orderSucceedExchange){
        return BindingBuilder.bind(orderSucceed).to(orderSucceedExchange);
    }

}
