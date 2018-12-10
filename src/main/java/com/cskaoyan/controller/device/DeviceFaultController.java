package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceFaultListVO;
import com.cskaoyan.service.devicr.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 11:59
 **/
@Controller
@RequestMapping("deviceFault")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("list")
    @ResponseBody
    public DeviceFaultListVO list(String page, String rows) {
        DeviceFaultListVO deviceFaultListVO = deviceFaultService.selectList(page, rows);
        return deviceFaultListVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Status add_judge() {
        return null;
    }

    @RequestMapping("add")
    public String add() {
        return "deviceFault_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Status insert(DeviceFault deviceFault) {
        Status status = deviceFaultService.insert(deviceFault);
        return status;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Status edit_judge() {
        return null;
    }

    @RequestMapping("edit")
    public String edit() {
        return "deviceFault_edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public Status update(DeviceFault deviceFault) {
        Status status = deviceFaultService.update(deviceFault);
        return status;
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Status delete_judge() {
        return null;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Status delete_batch(String ids) {
        Status status = deviceFaultService.deleteByPrimaryKey(ids);
        return status;
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public DeviceFault get(@PathVariable String id) {
        return deviceFaultService.get(id);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public DeviceFault[] getData() {
        return deviceFaultService.getData();
    }

    @RequestMapping("search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public DeviceFaultListVO searchDeviceFaultByDeviceFaultId(String page, String rows, String searchValue) {
        DeviceFaultListVO deviceFaultListVO = deviceFaultService.searchDeviceFaultByDeviceFaultId(page, rows, searchValue);
        return deviceFaultListVO;
    }

    @RequestMapping("search_deviceFault_by_deviceName")
    @ResponseBody
    public DeviceFaultListVO searchDeviceFaultByDeviceName(String page, String rows, String searchValue) {
        DeviceFaultListVO deviceFaultListVO = deviceFaultService.searchDeviceFaultByDeviceName(page, rows, searchValue);
        return deviceFaultListVO;
    }
}
