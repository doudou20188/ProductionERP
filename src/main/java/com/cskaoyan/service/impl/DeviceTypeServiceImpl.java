package com.cskaoyan.service.impl;

import com.cskaoyan.domain.DeviceType;
import com.cskaoyan.domain.DeviceTypeListVO;
import com.cskaoyan.domain.Status;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
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
//        deviceTypeMapper
//        Status status =new Status();
//        if (b>0){
//            status.setMsg("OK");
//            status.setData("");
//            status.setStatus("200");
//        }
        return null;
    }
}
