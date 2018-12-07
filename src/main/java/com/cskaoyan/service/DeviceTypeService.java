package com.cskaoyan.service;

import com.cskaoyan.domain.DeviceType;
import com.cskaoyan.domain.DeviceTypeListVO;
import com.cskaoyan.domain.Status;

public interface DeviceTypeService {

    DeviceTypeListVO deviceTypeList(String page, String rows);

    Status deleteByPrimaryKey(String ids);

    Status insert(DeviceType deviceType);
}
