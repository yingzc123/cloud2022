package com.yzc.cloud.service;

import com.yzc.cloud.entity.SubMeter;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sanz
 * @since 2022-07-07
 */
public interface SubMeterService extends IService<SubMeter> {
    void setThread();

    void getThread();

}
