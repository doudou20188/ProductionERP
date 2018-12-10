package com.cskaoyan.service.devicr;

import com.cskaoyan.domain.device.DeviceType;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceTypeListVO;

public interface DeviceTypeService {

    DeviceTypeListVO deviceTypeList(String page, String rows);

    Status deleteByPrimaryKey(String ids);

    Status insert(DeviceType deviceType);

    Status update(DeviceType deviceType);

    DeviceType selectByPrimaryKey(String ids);

    DeviceType[] get_data();

    DeviceTypeListVO searchDeviceTypeByDeviceTypeId(String page, String rows, String searchValue);

    DeviceTypeListVO searchDeviceTypeByDeviceTypeName(String page, String rows, String searchValue);
}
