package com.cskaoyan.mapper;

import com.cskaoyan.domain.device_type;

public interface device_typeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(device_type record);

    int insertSelective(device_type record);

    device_type selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(device_type record);

    int updateByPrimaryKey(device_type record);
}