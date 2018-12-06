package com.cskaoyan.service.impl;

import com.cskaoyan.domain.Device;
import com.cskaoyan.domain.DeviceTypeListVO;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 20:42
 **/
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public DeviceTypeListVO deviceTypeList(String page, String rows) {
        List<Device> devices = deviceMapper.deviceList();
        System.out.println(devices);
        return null;
    }
}
