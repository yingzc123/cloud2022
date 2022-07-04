package com.yzc.cloud.service;

import com.yzc.cloud.entity.OrderTest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-22
 */
public interface OrderTestService extends IService<OrderTest> {

    List<OrderTest> listMysqlGet();

    List<OrderTest> listSqlServerGet();

}
