package com.cskaoyan.service.Devicr;

import com.cskaoyan.domain.Device.Device;
import com.cskaoyan.domain.Device.DeviceListVO;
import com.cskaoyan.domain.Device.Status;

public interface DeviceService {
    DeviceListVO selectList(String page, String rows);

    Status insert(Device device);

    Status update(Device device);

    Status deleteByPrimaryKey(String ids);

    Status updateNote(String deviceId, String note);
}
