package com.yzc.cloud.service.impl;

import com.yzc.cloud.entity.OrderTest;
import com.yzc.cloud.dao.OrderTestMapper;
import com.yzc.cloud.service.OrderTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-22
 */
@Service
public class OrderTestServiceImpl extends ServiceImpl<OrderTestMapper, OrderTest> implements OrderTestService {

    @Override
    public List<OrderTest> listMysqlGet() {
        return list();
    }

    @Override
    public List<OrderTest> listSqlServerGet() {
        return list();
    }


}
