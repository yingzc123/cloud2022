package com.yzc.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yzc.cloud.annotation.YZC;
import com.yzc.cloud.entity.CloudOrder;
import com.yzc.cloud.dao.CloudOrderMapper;
import com.yzc.cloud.entity.Coupon;
import com.yzc.cloud.feign.proxyFeign.ProxyUserFeign;
import com.yzc.cloud.service.CloudOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzc.cloud.service.CouponService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-21
 */
@Service
@Slf4j
public class CloudOrderServiceImpl extends ServiceImpl<CloudOrderMapper, CloudOrder> implements CloudOrderService {
    @Autowired
    private ProxyUserFeign proxyUserFeign;

    @Autowired
    @Lazy
    private  CloudOrderService cloudOrderService;
    @Autowired
    private CouponService couponService;

    /**
     * 测试分布式事务
     */
    @Override
   // @GlobalTransactional
    @Transactional
    public void updateOrder() {
        new ConcurrentHashMap();
        proxyUserFeign.updateUser();
        //测试执行两个数据源同时修改会一起回滚否
      //  update(new UpdateWrapper<CloudOrder>().set("order_no","abnormalMaster").eq("order_id",1));
       /* cloudOrderService.abnormalAffair();
        couponService.updateCoupon();*/
        update(new UpdateWrapper<CloudOrder>().set("order_no","abnormalMaster").eq("order_id",1));
        System.out.println("sb");
        int i= 3/0;

    }
    @Override
    @YZC("servant")
    public void abnormalAffair() {
        update(new UpdateWrapper<CloudOrder>().set("order_no","abnormalServant").eq("order_id",1));
    }

    /**
     * 切换数据源
     */
    @Override
    @YZC("servant")
    public CloudOrder getServant() {
        return  getById(1);
    }

    @Override
    public void meanwhileUp() {
        CloudOrder master = getById(1);
        log.info("master:{}",master);
        //这里调动了servant数据源 下面全是走servant 除非下面执行的方法也带上YZC注解才会切换数据源
        CloudOrder servant = cloudOrderService.getServant();
        log.info("servant:{}",servant);
        CloudOrder master2 = getById(1);
        log.info("master2:{}",master2);
        Coupon coupon = couponService.getCoupon();
        log.info("coupon??:{}",coupon);

    }




}
