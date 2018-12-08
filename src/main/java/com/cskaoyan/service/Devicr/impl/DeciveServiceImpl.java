package com.cskaoyan.service.Devicr.impl;

import com.cskaoyan.domain.Device.Device;
import com.cskaoyan.domain.Device.DeviceListVO;
import com.cskaoyan.domain.Device.Status;
import com.cskaoyan.mapper.Device.DeviceMapper;
import com.cskaoyan.service.Devicr.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/7 23:04
 **/
@Service
public class DeciveServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public DeviceListVO selectList(String page, String rows) {
        List<Device> deviceList = deviceMapper.selectList();
        Device[] devices=new Device[deviceList.size()];
        deviceList.toArray(devices);
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        DeviceListVO deviceListVO=new DeviceListVO();
        deviceListVO.setRows(devices);
        deviceListVO.setTotal(devices.length);
        return deviceListVO;
    }

    @Override
    public Status insert(Device device) {
        int b = deviceMapper.inserDevice(device);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status update(Device device) {
        int b = deviceMapper.updateDevice(device);
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
        int b = deviceMapper.deleteByPrimaryKey(deviceId);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status updateNote(String deviceId, String note) {
        int b = deviceMapper.updateNote(deviceId, note);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }
}
