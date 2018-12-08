package com.cskaoyan.service.devicr.impl;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceCheckVO;
import com.cskaoyan.mapper.device.DeviceCheckMapper;
import com.cskaoyan.service.devicr.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/8 17:28
 **/
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public DeviceCheckVO list(String page, String rows) {
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.selectList();
        DeviceCheck[] devices = new DeviceCheck[deviceCheckList.size()];
        deviceCheckList.toArray(devices);
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
        DeviceCheckVO deviceCheckVO = new DeviceCheckVO();
        deviceCheckVO.setRows(devices);
        deviceCheckVO.setTotal(devices.length);
        return deviceCheckVO;
    }

    @Override
    public Status insert(DeviceCheck deviceCheck) {
        int b = deviceCheckMapper.insert(deviceCheck);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status update(DeviceCheck deviceCheck) {
        int b = deviceCheckMapper.update(deviceCheck);
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
        int b = deviceCheckMapper.deleteByPrimaryKey(deviceId);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }

    @Override
    public Status updateNote(String deviceCheckId, String deviceCheckResult) {
        int b = deviceCheckMapper.updateNote(deviceCheckId, deviceCheckResult);
        Status status = new Status();
        if (b > 0) {
            status.setMsg("OK");
            status.setData("");
            status.setStatus("200");
        }
        return status;
    }
}
