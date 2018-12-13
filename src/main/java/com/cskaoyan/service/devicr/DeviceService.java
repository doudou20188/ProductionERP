package com.cskaoyan.service.devicr;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceListVO;

public interface DeviceService {
    DeviceListVO selectList(String page, String rows);

    Status insert(Device device);

    Status update(Device device);

    Status deleteByPrimaryKey(String ids);

    Status updateNote(String deviceId, String note);

    Device get(String id);

    Device[] getData();

    DeviceListVO searchDeviceByDeviceId(String page, String rows, String searchValue);

    DeviceListVO searchDeviceByDeviceName(String page, String rows, String searchValue);

    DeviceListVO searchDeviceByDeviceTypeName(String page, String rows, String searchValue);
}
