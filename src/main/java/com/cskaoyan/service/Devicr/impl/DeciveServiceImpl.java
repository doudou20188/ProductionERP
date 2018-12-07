package com.cskaoyan.service.Devicr.impl;

import com.cskaoyan.domain.Device.Device;
import com.cskaoyan.domain.Device.DeviceListVO;
import com.cskaoyan.mapper.Device.DeviceMapper;
import com.cskaoyan.service.Devicr.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/7 23:04
 **/
@Service
public class DeciveServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public DeviceListVO selectList(String page, String rows) {
        List<Device> deviceList = deviceMapper.selectList();
        Device[] devices=new Device[deviceList.size()];
        deviceList.toArray(devices);
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        DeviceListVO deviceListVO=new DeviceListVO();
        deviceListVO.setRows(devices);
        deviceListVO.setTotal(devices.length);
        return deviceListVO;
    }
}
