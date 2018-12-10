package com.cskaoyan.mapper;

import com.cskaoyan.domain.device;

public interface deviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(device record);

    int insertSelective(device record);

    device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(device record);

    int updateByPrimaryKey(device record);
}