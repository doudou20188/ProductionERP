package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Device;

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
