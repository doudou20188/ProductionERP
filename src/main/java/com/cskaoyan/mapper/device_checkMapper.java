package com.cskaoyan.mapper;

import com.cskaoyan.domain.device_check;

public interface device_checkMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(device_check record);

    int insertSelective(device_check record);

    device_check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(device_check record);

    int updateByPrimaryKey(device_check record);
}