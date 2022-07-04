package com.yzc.cloud.result;

/**
 * 抽象枚举
 */
public interface ResultEnumerable {
    Integer getCode();

    String getMsg();

    @Override
    String toString();
}
