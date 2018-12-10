package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.Device;

import java.util.List;

public interface DeviceMapper {
    public List<Device> selectList();

    int inserDevice(Device device);

    int updateDevice(Device device);

    int deleteByPrimaryKey(String deviceId);

    int updateNote(String deviceId, String note);

    Device get(String id);
}
