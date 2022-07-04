package com.yzc.cloud.controller;


import cn.hutool.json.JSONUtil;
import com.yzc.cloud.entity.OrderTest;
import com.yzc.cloud.service.OrderTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Sanz
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderTestService  orderTestService;


    @GetMapping
    public void test(){
        List<OrderTest> mysqlGet = orderTestService.listMysqlGet();
        log.info("mysqlGet:{}", JSONUtil.toJsonStr(mysqlGet));
        List<OrderTest> sqlServerGet = orderTestService.listSqlServerGet();
        log.info("sqlServerGet:{}", JSONUtil.toJsonStr(sqlServerGet));

    }

}
