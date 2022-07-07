package com.yzc.cloud.controller;


import com.yzc.cloud.service.SubMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Sanz
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/subMeter")
public class SubMeterController {
    @Autowired
    private SubMeterService subMeterService;


    @GetMapping
    public void testSubMeter(){
        subMeterService.setThread();
    }

    @GetMapping("/get")
    public void get(){
        subMeterService.getThread();
    }


}
