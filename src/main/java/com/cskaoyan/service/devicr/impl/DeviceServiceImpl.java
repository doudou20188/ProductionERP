package com.cskaoyan.service.devicr.impl;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceListVO;
import com.cskaoyan.mapper.device.DeviceMapper;
import com.cskaoyan.service.devicr.DeviceService;
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
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public DeviceListVO selectList(String page, String rows) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<Device> deviceList = deviceMapper.selectList();
        Device[] devices=new Device[deviceList.size()];
        deviceList.toArray(devices);
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

    @Override
    public Device get(String id) {
        return deviceMapper.get(id);
    }

    @Override
    public Device[] getData() {
        List<Device> deviceList = deviceMapper.selectList();
        Device[] devices = new Device[deviceList.size()];
        deviceList.toArray(devices);
        return devices;
    }
}
