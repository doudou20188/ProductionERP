package com.cskaoyan.controller;

import com.cskaoyan.dao.Device;
import com.cskaoyan.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 12:39
 **/
@Controller
public class mainController {
    @Autowired
    DeviceMapper deviceMapper;
    @RequestMapping("/{name}")
    public String main(@PathVariable String name){
        System.out.println(name);
        Device device = deviceMapper.selectByPrimaryKey("001");
        System.out.println(device);
        return name;
    }
}
