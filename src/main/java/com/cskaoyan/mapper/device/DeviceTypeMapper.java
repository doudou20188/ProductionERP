package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    public List<DeviceType> deviceTypeList();

    public int deleteByPrimaryKey(String deviceTypeId);

    public int insertDeviceType(DeviceType deviceType);

    public int updateDeviceType(DeviceType deviceType);

    DeviceType selectByPrimaryKey(String ids);

    List<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue);

    List<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue);
}