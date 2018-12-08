package com.cskaoyan.service.Devicr.impl;

import com.cskaoyan.domain.Device.DeviceType;
import com.cskaoyan.domain.Device.DeviceTypeListVO;
import com.cskaoyan.domain.Device.Status;
import com.cskaoyan.mapper.Device.DeviceTypeMapper;
import com.cskaoyan.service.Devicr.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 20:42
 **/
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public DeviceTypeListVO deviceTypeList(String page, String rows) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<DeviceType> deviceTypeList = deviceTypeMapper.deviceTypeList();
        DeviceType[] deviceTypes = new DeviceType[deviceTypeList.size()];
        deviceTypeList.toArray(deviceTypes);
        DeviceTypeListVO deviceTypeListVO =new DeviceTypeListVO();
        deviceTypeListVO.setRows(deviceTypes);
        deviceTypeListVO.setTotal(deviceTypeList.size());
        return deviceTypeListVO;
    }

    @Override
    public Status deleteByPrimaryKey(String deviceTypeId) {
        int b =deviceTypeMapper.deleteByPrimaryKey(deviceTypeId);
        Status status =new Status();
        if (b>0){
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status insert(DeviceType deviceType) {
        int b=deviceTypeMapper.insertDeviceType(deviceType);
        Status status =new Status();
        if (b>0){
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status update(DeviceType deviceType) {
        int b=deviceTypeMapper.updateDeviceType(deviceType);
        Status status =new Status();
        if (b>0){
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public DeviceType selectByPrimaryKey(String ids) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(ids);
        return deviceType;
    }

    @Override
    public DeviceType[] get_data() {
        List<DeviceType> deviceTypeList = deviceTypeMapper.deviceTypeList();
        DeviceType[] deviceTypes = new DeviceType[deviceTypeList.size()];
        deviceTypeList.toArray(deviceTypes);
        return deviceTypes;
    }
}
