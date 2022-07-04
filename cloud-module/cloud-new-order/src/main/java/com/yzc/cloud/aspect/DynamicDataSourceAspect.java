package com.yzc.cloud.aspect;


import com.yzc.cloud.annotation.YZC;
import com.yzc.cloud.config.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/***
Sanz
 */
@Component
@Aspect
@Order(0)
public class DynamicDataSourceAspect  {

    // 前置
    @Before("within(com.yzc.cloud.service.impl.*) && @annotation(yzc)")
    public void before(JoinPoint point, YZC yzc){
        String name = yzc.value();
        DynamicDataSource.name.set(name);

        System.out.println("执行的数据源"+name);
    }

}
