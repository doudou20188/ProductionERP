package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceFault;

import java.util.List;

public interface DeviceFaultMapper {
    List<DeviceFault> selectList();

    int insertDeviceFault(DeviceFault deviceFault);

    int updateDevice(DeviceFault deviceFault);

    int deleteByPrimaryKey(String deviceFaultId);

    DeviceFault get(String id);
}
