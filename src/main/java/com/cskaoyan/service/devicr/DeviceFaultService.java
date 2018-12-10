package com.cskaoyan.service.devicr;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceFaultListVO;

public interface DeviceFaultService {
    DeviceFaultListVO selectList(String page, String rows);

    Status insert(DeviceFault deviceFault);

    Status update(DeviceFault deviceFault);

    Status deleteByPrimaryKey(String ids);

    DeviceFault get(String id);

    DeviceFault[] getData();

    DeviceFaultListVO searchDeviceFaultByDeviceFaultId(String page, String rows, String searchValue);

    DeviceFaultListVO searchDeviceFaultByDeviceName(String page, String rows, String searchValue);
}
