package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceMaintainListVO;
import com.cskaoyan.service.devicr.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/9 13:29
 **/
@Controller
@RequestMapping("deviceMaintain")
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("list")
    @ResponseBody
    public DeviceMaintainListVO list(String page, String rows) {
        DeviceMaintainListVO deviceMaintainListVO = deviceMaintainService.selectList(page, rows);
        return deviceMaintainListVO;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Status add_judge() {
        return null;
    }

    @RequestMapping("add")
    public String add() {
        return "deviceMaintain_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Status insert(DeviceMaintain deviceMaintain) {
        Status status = deviceMaintainService.insert(deviceMaintain);
        return status;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Status edit_judge() {
        return null;
    }

    @RequestMapping("edit")
    public String edit() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public Status update(DeviceMaintain deviceMaintain) {
        Status status = deviceMaintainService.update(deviceMaintain);
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
        Status status = deviceMaintainService.deleteByPrimaryKey(ids);
        return status;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Status updateNote(String deviceMaintainId, String note) {
        Status status = deviceMaintainService.updateNote(deviceMaintainId, note);
        return status;
    }

    @RequestMapping("search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public DeviceMaintainListVO searchDeviceMaintainByDeviceMaintainId(String page, String rows, String searchValue) {
        DeviceMaintainListVO deviceMaintainListVO = deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page, rows, searchValue);
        return deviceMaintainListVO;
    }

    @RequestMapping("search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public DeviceMaintainListVO searchDeviceMaintainByDeviceFaultId(String page, String rows, String searchValue) {
        DeviceMaintainListVO deviceMaintainListVO = deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page, rows, searchValue);
        return deviceMaintainListVO;
    }
}
