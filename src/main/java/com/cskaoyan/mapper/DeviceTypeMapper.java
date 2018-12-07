package com.cskaoyan.mapper;

import com.cskaoyan.domain.DeviceType;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {
    public List<DeviceType> deviceTypeList();

    public int deleteByPrimaryKey(String deviceTypeId);

    public int insertDeviceType(DeviceType deviceType);
}