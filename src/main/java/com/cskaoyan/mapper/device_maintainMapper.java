package com.cskaoyan.mapper;

import com.cskaoyan.domain.device_maintain;

public interface device_maintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(device_maintain record);

    int insertSelective(device_maintain record);

    device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(device_maintain record);

    int updateByPrimaryKey(device_maintain record);
}