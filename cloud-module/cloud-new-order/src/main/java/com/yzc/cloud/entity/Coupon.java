package com.yzc.cloud.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sanz
 * @since 2022-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "coupon_id", type = IdType.AUTO)
    private Integer couponId;

    private String couponName;

    private BigDecimal couponMoney;


}
