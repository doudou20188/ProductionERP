package com.cskaoyan.controller.Device;

import com.cskaoyan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/7 14:41
 **/
@SuppressWarnings("ALL")
@Controller
@RequestMapping("device")
public class DeviceController {
    /*
     * @Author lyboy
     * @Description //TODO
     * @Date 14:43 2018/12/7
     * @Param [session]
     * @return java.lang.String
     * 设备种类转发jsp组件的控制器
     * 黑洞
     */
    @RequestMapping("deviceType")
    public String deviceType(HttpSession session){
        User activeuser = (User) session.getAttribute("activeUser");
        if (activeuser.getLocked().equals("1")){
            List<String> sysPermissionList=new ArrayList<>();
            sysPermissionList.add("deviceType:add");
            sysPermissionList.add("deviceType:edit");
            sysPermissionList.add("deviceType:delete");
            session.setAttribute("sysPermissionList",sysPermissionList);
        }
        return "deviceType";
    }
    @RequestMapping("deviceList")
    public String deviceList(){
        return "deviceList";
    }
}
