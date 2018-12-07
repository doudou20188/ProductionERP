package com.cskaoyan.service.Devicr;

import com.cskaoyan.domain.Device.DeviceListVO;

public interface DeviceService {
    DeviceListVO selectList(String page, String rows);
}
