package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceCheckListVO;
import com.cskaoyan.service.devicr.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/8 17:14
 **/
@Controller
@RequestMapping(value = {"DeviceCheck", "deviceCheck"})
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public DeviceCheckListVO list(String page, String rows) {
        return deviceCheckService.list(page, rows);
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Status add_judge() {
        return null;
    }

    @RequestMapping("add")
    public String add() {
        return "deviceCheck_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Status insert(DeviceCheck deviceCheck) {
        Status status = deviceCheckService.insert(deviceCheck);
        return status;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Status edit_judge() {
        return null;
    }

    @RequestMapping("edit")
    public String edit() {
        return "deviceCheck_edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public Status update(DeviceCheck deviceCheck) {
        Status status = deviceCheckService.update(deviceCheck);
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
        Status status = deviceCheckService.deleteByPrimaryKey(ids);
        return status;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Status updateNote(String deviceCheckId, String deviceCheckResult) {
        Status status = deviceCheckService.updateNote(deviceCheckId, deviceCheckResult);
        return status;
    }
}
