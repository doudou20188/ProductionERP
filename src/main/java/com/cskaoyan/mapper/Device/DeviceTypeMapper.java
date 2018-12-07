package com.cskaoyan.mapper.Device;

import com.cskaoyan.domain.Device.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    public List<DeviceType> deviceTypeList();

    public int deleteByPrimaryKey(String deviceTypeId);

    public int insertDeviceType(DeviceType deviceType);

    public int updateDeviceType(DeviceType deviceType);
}