package com.cskaoyan.service.Devicr;

import com.cskaoyan.domain.Device.DeviceType;
import com.cskaoyan.domain.Device.DeviceTypeListVO;
import com.cskaoyan.domain.Device.Status;

public interface DeviceTypeService {

    DeviceTypeListVO deviceTypeList(String page, String rows);

    Status deleteByPrimaryKey(String ids);

    Status insert(DeviceType deviceType);

    Status update(DeviceType deviceType);
}
