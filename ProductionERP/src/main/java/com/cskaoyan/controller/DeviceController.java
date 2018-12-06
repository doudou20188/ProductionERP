package com.cskaoyan.controller;

import com.cskaoyan.domain.Device;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 20:24
 **/
@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    /**
     * @Author lyboy
     * @Description //TODO
     * @Date 21:01 2018/12/6
     * @Param []
     * @return java.lang.String
     *
     *转发jsp组件
     */
    @RequestMapping("device/deviceList")
    public String deviceList(){
        return "deviceList";
    }
    @RequestMapping("deviceList/list")
    @ResponseBody
    public List<Device> list(String page,String rows){

        System.out.println(page+"-"+rows);
        return null;
    }
}
