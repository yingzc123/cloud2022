package com.yzc.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yzc.cloud.annotation.YZC;
import com.yzc.cloud.entity.CloudOrder;
import com.yzc.cloud.entity.Coupon;
import com.yzc.cloud.dao.CouponMapper;
import com.yzc.cloud.service.CouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sanz
 * @since 2022-07-03
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {

    @Override
    @YZC
    public Coupon getCoupon() {
        return getById(1);
    }

    @Override
    @YZC("servant")
    public void updateCoupon() {
        update(new UpdateWrapper<Coupon>().set("coupon_name","我是仆人优惠卷").eq("coupon_id",1));


    }
}
