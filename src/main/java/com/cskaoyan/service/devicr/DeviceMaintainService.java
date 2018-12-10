package com.cskaoyan.service.devicr;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceMaintainListVO;

public interface DeviceMaintainService {
    DeviceMaintainListVO selectList(String page, String rows);

    Status insert(DeviceMaintain deviceMaintain);

    Status update(DeviceMaintain deviceMaintain);

    Status deleteByPrimaryKey(String ids);

    Status updateNote(String deviceCheckId, String deviceCheckResult);
}
