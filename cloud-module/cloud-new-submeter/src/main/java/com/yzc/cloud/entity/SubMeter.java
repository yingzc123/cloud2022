package com.yzc.cloud.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sanz
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SubMeter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;


}
