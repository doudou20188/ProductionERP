package com.cskaoyan.service.impl;

import com.cskaoyan.domain.Device;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public Device findDeviceById(String deviceId) {
        Device device = deviceMapper.selectByPrimaryKey(deviceId);
        return device;
    }

    @Override
    public List<Device> findAllDevices() {

        List<Device> deviceList=deviceMapper.findAllDevicesFromDB();
        return deviceList;
    }

    @Override
    public Device findDeviceByName(String searchValue) {
        Device device=deviceMapper.findDeviceByNameFromDB(searchValue);

        return device;
    }
}
