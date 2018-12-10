package com.cskaoyan.mapper;

import com.cskaoyan.domain.device_fault;

public interface device_faultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(device_fault record);

    int insertSelective(device_fault record);

    device_fault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(device_fault record);

    int updateByPrimaryKey(device_fault record);
}