package com.yzc.cloud.entity.dto;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: SanZ
 * @DATE: 2022/7/7 9:48
 */
public class CloudOrderDTO {

    @Data
    public static  class Test{
        @NotNull(message = "id不能为空")
       private Integer id;

        @NotEmpty(message = "名字不能为空")
        private String name;
    }
}
