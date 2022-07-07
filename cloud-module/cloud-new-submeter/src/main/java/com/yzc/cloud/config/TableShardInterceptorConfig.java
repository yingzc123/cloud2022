package com.yzc.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 *  SanZ 全局配置 不建议修改
 */
@Slf4j
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class TableShardInterceptorConfig implements Interceptor {
        /**
         * author:SanZ
         * DATE:2022/5/6
         */
        @Override
        public Object intercept(Invocation invocation) throws Throwable {
                StatementHandler handler = (StatementHandler) invocation.getTarget();
                BoundSql boundSql = handler.getBoundSql();
                String sql = boundSql.getSql();
                log.info("原sql======="+sql);
                if (null != TenantContext.getPOSTFIX()){
                        log.info("getTableName======="+TenantContext.getTableName());
                        log.info("getOrgCd======="+TenantContext.getPOSTFIX());
                        sql=sql.replace(TenantContext.getTableName(),TenantContext.getTableName()+TenantContext.getPOSTFIX());
                        log.info("替换表名后sql======="+sql);
                }
                Field sqlField = boundSql.getClass().getDeclaredField("sql");
                sqlField.setAccessible(true);
                sqlField.set(boundSql, sql);
                return invocation.proceed();


        }





}
