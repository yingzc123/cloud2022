package com.yzc.cloud.service.impl;

import com.yzc.cloud.config.TenantContext;
import com.yzc.cloud.entity.SubMeter;
import com.yzc.cloud.dao.SubMeterMapper;
import com.yzc.cloud.service.SubMeterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sanz
 * @since 2022-07-07
 */
@Service
public class SubMeterServiceImpl extends ServiceImpl<SubMeterMapper, SubMeter> implements SubMeterService {

    @Autowired
    private ThreadPoolTaskExecutor getAsyncExecutor;
   
    @Override
    public void setThread() {
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            getAsyncExecutor.execute(()->{
                TenantContext.setTableName("sub_mete");
                TenantContext.setPOSTFIX("_"+ finalI);
                System.out.println(Thread.currentThread().getName()+"__"+TenantContext.getTableName()+TenantContext.getPOSTFIX());
                TenantContext.removeTableName();
                TenantContext.removePOSTFIX();
            });
        }
    }
    @Override
    public void getThread() {
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            getAsyncExecutor.execute(()->{
                //测试
                System.out.println("读的-------------------------------"+Thread.currentThread().getName()+"__"+TenantContext.getTableName()+TenantContext.getPOSTFIX());
            });
        }
    }

    @Override
    public void toException() {
        int i= 3/0;
    }
}
