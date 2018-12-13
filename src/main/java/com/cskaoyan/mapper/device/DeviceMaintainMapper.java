package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainMapper {

    List<DeviceMaintain> selectList();

    int insertDeviceMaintain(DeviceMaintain deviceMaintain);

    int updateDeviceMaintain(DeviceMaintain deviceMaintain);

    int deleteByPrimaryKey(String deviceId);

    int updateNote(String deviceMaintainId, String deviceMaintainResult);

    List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String searchValue);

    List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String searchValue);
}