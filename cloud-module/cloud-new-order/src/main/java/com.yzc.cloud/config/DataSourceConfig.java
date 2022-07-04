package com.yzc.cloud.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

/***
Sanz
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.order-master")
    public DataSource orderMaster() {
        // 底层会自动拿到spring.datasource中的配置， 创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.order-servant")
    public DataSource orderServant() {
        // 底层会自动拿到spring.datasource中的配置， 创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 构造datasource代理对象，替换原来的orderMasterDatasource
     * @param orderMaster
     * @return
     */
    @Bean("orderSourceMaster")
    public DataSourceProxy orderSourceMaster(@Qualifier("orderMaster")DataSource orderMaster) {
        return new DataSourceProxy(orderMaster);
    }

    /**
     * 构造datasource代理对象，替换原来的orderServantDatasource
     * @param orderServant
     * @return
     */
    @Bean("orderSourceServant")
    public DataSourceProxy orderSourceServant(@Qualifier("orderServant")DataSource orderServant) {
        return new DataSourceProxy(orderServant);
    }


}
