package com.yzc.cloud.service;

import com.yzc.cloud.entity.CloudOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-21
 */
public interface CloudOrderService extends IService<CloudOrder> {

    void updateOrder();

    CloudOrder getServant();

    void meanwhileUp();

    void abnormalAffair();


}
