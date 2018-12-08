package com.cskaoyan.service.devicr;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceCheckVO;

public interface DeviceCheckService {
    DeviceCheckVO list(String page, String rows);

    Status insert(DeviceCheck device);

    Status update(DeviceCheck deviceCheck);

    Status deleteByPrimaryKey(String ids);

    Status updateNote(String deviceId, String note);
}
