package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceCheck;

import java.util.List;

public interface DeviceCheckMapper {
    List<DeviceCheck> selectList();

    int insert(DeviceCheck deviceCheck);

    int update(DeviceCheck deviceCheck);

    int deleteByPrimaryKey(String deviceId);

    int updateNote(String deviceCheckId, String note);
}
