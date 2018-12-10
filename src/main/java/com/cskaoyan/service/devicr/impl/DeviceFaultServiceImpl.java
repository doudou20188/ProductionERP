package com.cskaoyan.service.devicr.impl;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceFaultListVO;
import com.cskaoyan.mapper.device.DeviceFaultMapper;
import com.cskaoyan.service.devicr.DeviceFaultService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 12:10
 **/
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public DeviceFaultListVO selectList(String page, String rows) {
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        List<DeviceFault> deviceList = deviceFaultMapper.selectList();
        DeviceFault[] deviceFaults = new DeviceFault[deviceList.size()];
        deviceList.toArray(deviceFaults);
        DeviceFaultListVO deviceFaultListVO = new DeviceFaultListVO();
        deviceFaultListVO.setRows(deviceFaults);
        deviceFaultListVO.setTotal(deviceFaults.length);
        return deviceFaultListVO;
    }

    @Override
    public Status insert(DeviceFault deviceFault) {
        int b = deviceFaultMapper.insertDeviceFault(deviceFault);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status update(DeviceFault deviceFault) {
        int b = deviceFaultMapper.updateDevice(deviceFault);
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
        int b = deviceFaultMapper.deleteByPrimaryKey(deviceId);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public DeviceFault get(String id) {
        return deviceFaultMapper.get(id);
    }

    @Override
    public DeviceFault[] getData() {
        List<DeviceFault> deviceList = deviceFaultMapper.selectList();
        DeviceFault[] deviceFaults = new DeviceFault[deviceList.size()];
        deviceList.toArray(deviceFaults);
        return deviceFaults;
    }
}
