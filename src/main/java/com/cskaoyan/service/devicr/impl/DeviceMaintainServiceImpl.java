package com.cskaoyan.service.devicr.impl;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceMaintainListVO;
import com.cskaoyan.mapper.device.DeviceMaintainMapper;
import com.cskaoyan.service.devicr.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 13:33
 **/
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public DeviceMaintainListVO selectList(String page, String rows) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.selectList();
        DeviceMaintain[] deviceMaintains = new DeviceMaintain[deviceMaintainList.size()];
        deviceMaintainList.toArray(deviceMaintains);
        DeviceMaintainListVO deviceMaintainListVO = new DeviceMaintainListVO();
        deviceMaintainListVO.setRows(deviceMaintains);
        deviceMaintainListVO.setTotal(deviceMaintains.length);
        return deviceMaintainListVO;
    }

    @Override
    public Status insert(DeviceMaintain deviceMaintain) {
        int b = deviceMaintainMapper.insertDeviceMaintain(deviceMaintain);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status update(DeviceMaintain deviceMaintain) {
        int b = deviceMaintainMapper.updateDeviceMaintain(deviceMaintain);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status deleteByPrimaryKey(String deviceId) {
        int b = deviceMaintainMapper.deleteByPrimaryKey(deviceId);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status updateNote(String deviceMaintainId, String note) {
        int b = deviceMaintainMapper.updateNote(deviceMaintainId, note);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public DeviceMaintainListVO searchDeviceMaintainByDeviceMaintainId(String page, String rows, String searchValue) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(searchValue);
        DeviceMaintain[] deviceMaintains = new DeviceMaintain[deviceMaintainList.size()];
        deviceMaintainList.toArray(deviceMaintains);
        DeviceMaintainListVO deviceMaintainListVO = new DeviceMaintainListVO();
        deviceMaintainListVO.setRows(deviceMaintains);
        deviceMaintainListVO.setTotal(deviceMaintains.length);
        return deviceMaintainListVO;
    }

    @Override
    public DeviceMaintainListVO searchDeviceMaintainByDeviceFaultId(String page, String rows, String searchValue) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(searchValue);
        DeviceMaintain[] deviceMaintains = new DeviceMaintain[deviceMaintainList.size()];
        deviceMaintainList.toArray(deviceMaintains);
        DeviceMaintainListVO deviceMaintainListVO = new DeviceMaintainListVO();
        deviceMaintainListVO.setRows(deviceMaintains);
        deviceMaintainListVO.setTotal(deviceMaintains.length);
        return deviceMaintainListVO;
    }
}
