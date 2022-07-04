package com.yzc.cloud.aspect;


import com.yzc.cloud.annotation.WR;
import com.yzc.cloud.config.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/***
Sanz
 */
@Component
@Aspect
public class DynamicDataSourceAspect implements Ordered {

    // 前置
    @Before("within(com.yzc.cloud.service.impl.*) && @annotation(wr)")
    public void before(JoinPoint point, WR wr){
        String name = wr.value();
        DynamicDataSource.name.set(name);

        System.out.println("执行的数据源"+name);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    // 环绕通知
}
