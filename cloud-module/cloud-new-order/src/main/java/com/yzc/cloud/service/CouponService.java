package com.yzc.cloud.service;

import com.yzc.cloud.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sanz
 * @since 2022-07-03
 */
public interface CouponService extends IService<Coupon> {

    Coupon getCoupon();

    void updateCoupon();

}
