package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceType;
import com.cskaoyan.domain.device.Status;
import com.cskaoyan.domain.device.vo.DeviceTypeListVO;
import com.cskaoyan.service.devicr.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 该控制器主要控制设备类型相关文件
 * @Author lyboy
 * @Date 2018/12/6 20:24
 **/
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    /**
     * @Author lyboy
     * @Description //TODO
     * @Date 21:01 2018/12/6
     * @Param []
     * @return java.lang.String
     *
     *返回设备类型列表
     */
    @RequestMapping("list")
    @ResponseBody
    public DeviceTypeListVO deviceTypeList(String page, String rows){
        DeviceTypeListVO deviceTypeListVO = deviceTypeService.deviceTypeList(page, rows);
        return deviceTypeListVO;
    }
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:44 2018/12/7
     * @Param []
     * @return 返回空的json字符猜测为权限控制
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public Status delete_judge(){
        return null;
    }
    /*
     * @Author lyboy
     * @Description 删除指定类型
     * @Date 14:46 2018/12/7
     * @Param [ids] 要删除的参数
     * @return 确认成功
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public Status delete_batch(String ids){
        System.out.println(ids);
        Status status = deviceTypeService.deleteByPrimaryKey(ids);
        return status;
    }
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:44 2018/12/7
     * @Param []
     * @return 返回空的json字符猜测为权限控制
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public Status add_judge(){
        return null;
    }
    @RequestMapping("add")
    public String add(){
        return "deviceType_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Status insert(DeviceType deviceType){
        return deviceTypeService.insert(deviceType);
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Status edit_judge(){
        return null;
    }
    @RequestMapping("edit")
    public String edit(){
        return "deviceType_edit";
    }
    @RequestMapping("update")
    @ResponseBody
    public Status update(DeviceType deviceType){
        return deviceTypeService.update(deviceType);
    }

    @RequestMapping("get/{ids}")
    @ResponseBody
    public DeviceType get(@PathVariable String ids) {
        return deviceTypeService.selectByPrimaryKey(ids);
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Status update_all(DeviceType deviceType) {
        return deviceTypeService.update(deviceType);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public DeviceType[] get_data() {
        DeviceType[] deviceTypes = deviceTypeService.get_data();
        return deviceTypes;
    }

    @RequestMapping("search_deviceType_by_deviceTypeId")
    @ResponseBody
    public DeviceTypeListVO searchDeviceTypeByDeviceTypeId(String page, String rows, String searchValue) {
        DeviceTypeListVO deviceTypeListVO = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
        return deviceTypeListVO;
    }

    @RequestMapping("search_deviceType_by_deviceTypeName")
    @ResponseBody
    public DeviceTypeListVO searchDeviceTypeByDeviceTypeName(String page, String rows, String searchValue) {
        DeviceTypeListVO deviceTypeListVO = deviceTypeService.searchDeviceTypeByDeviceTypeName(page, rows, searchValue);
        return deviceTypeListVO;
    }
}
