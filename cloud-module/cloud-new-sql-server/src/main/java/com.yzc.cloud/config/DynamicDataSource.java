package com.yzc.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/***
 * Sanz
 */
@Component
@Primary   // 将该Bean设置为主要注入Bean
public class DynamicDataSource extends AbstractRoutingDataSource {


    // 当前使用的数据源标识
    public static ThreadLocal<String> name = new ThreadLocal<>();

    @Autowired
    DataSource mysqlCloud;
    @Autowired
    DataSource sqlServerCloud;


    // 返回当前数据源标识
    @Override
    protected Object determineCurrentLookupKey() {
        return name.get();

    }


    @Override
    public void afterPropertiesSet() {

        // 为targetDataSources初始化所有数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("mysql", mysqlCloud);
        targetDataSources.put("sqlServer", sqlServerCloud);

        super.setTargetDataSources(targetDataSources);

        // 为defaultTargetDataSource 设置默认的数据源
        super.setDefaultTargetDataSource(mysqlCloud);

        super.afterPropertiesSet();
    }
}
