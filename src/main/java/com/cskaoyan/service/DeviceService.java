package com.cskaoyan.service;

import com.cskaoyan.domain.Device;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
public interface DeviceService {
    Device findDeviceById(String deviceId);

    List<Device> findAllDevices();

    Device findDeviceByName(String searchValue);
}
