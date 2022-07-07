package com.yzc.cloud.controller;


import com.yzc.cloud.entity.CloudOrder;
import com.yzc.cloud.entity.dto.CloudOrderDTO;
import com.yzc.cloud.result.ResultObject;
import com.yzc.cloud.service.CloudOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Sanz
 * @since 2022-06-21
 */
@RestController
@RequestMapping("/cloudOrder")
@Slf4j
public class CloudOrderController {

    @Autowired
    private CloudOrderService cloudOrderService;

    @PostMapping
    public List<CloudOrder> returnList(@RequestBody  @Valid CloudOrderDTO.Test dto){
        log.info("我被调用了:{}","niu");
        return cloudOrderService.list();
    }


    @PostMapping("/update")
    public void updateTest(){
        log.info("我被调用了:{}","niu");
        cloudOrderService.updateOrder();
    }

    @PostMapping("/dataSource")
    public ResultObject dataSource(){
    return ResultObject.success(cloudOrderService.getServant());
    }

    @PostMapping("/meanwhileUp")
    public ResultObject meanwhileUp(){
        cloudOrderService.meanwhileUp();
        return ResultObject.success(200);
    }

}
