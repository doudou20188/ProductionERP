package com.cskaoyan.service;

import com.cskaoyan.domain.DeviceTypeListVO;

public interface DeviceService {

    DeviceTypeListVO deviceTypeList(String page, String rows);
}
