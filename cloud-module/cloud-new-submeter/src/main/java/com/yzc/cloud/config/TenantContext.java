package com.yzc.cloud.config;

/**
 *  SanZ 全局配置 不建议修改
 */
public class TenantContext {
    private static final ThreadLocal<String> TABLE_NAME = new ThreadLocal<>();
    private static final ThreadLocal<String> TABLE_POSTFIX = new ThreadLocal<>();
    private TenantContext() {
    }

    public static void setPOSTFIX(String orgCd) {
        TABLE_POSTFIX.set(orgCd);
    }

    public static String getPOSTFIX() {
        return TABLE_POSTFIX.get();
    }

    public static void removePOSTFIX() {
        TABLE_POSTFIX.remove();
    }

    public static void setTableName(String tableName) {
        TABLE_NAME.set(tableName);
    }

    public static String getTableName() {
        return TABLE_NAME.get();
    }
    public static void removeTableName() {
        TABLE_NAME.remove();
    }

}
