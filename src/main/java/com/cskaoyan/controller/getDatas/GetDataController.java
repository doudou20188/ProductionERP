package com.cskaoyan.controller.getDatas;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.domain.yangtao.*;
import com.cskaoyan.domain.yangtao.Process;
import com.cskaoyan.service.devicr.DeviceService;
import com.cskaoyan.service.yangtao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 下拉框数据获取
 * @Auther: YangTao
 * @Date: 2018/12/10 0010
 */
@Controller
public class GetDataController {
    @Autowired
    CorderService corderService;
    @Autowired
    TechnologyService technologyService;
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;
    @Autowired
    TaskService taskService;
    @Autowired
    ProcessService processService;
    

    /**
     * ajax 下拉框数据获取
     * @return
     */
    @ResponseBody
    @RequestMapping("order/get_data")
    public List<Corder> ajaxOrderGetData(){
        List<Corder> corderList=corderService.findAllOrder();
        return corderList;
    }

    @ResponseBody
    @RequestMapping("technology/get_data")
    public List<Technology> ajaxTechnologyGetData(){
        List<Technology> technologyList=technologyService.finAllTechnology();
        return technologyList;
    }
    @ResponseBody
    @RequestMapping("custom/get_data")
    public List<Custom> ajaxCustomGetData(){
        List<Custom> customList=customService.findAllCustom();
        return customList;
    }
    @ResponseBody
    @RequestMapping("product/get_data")
    public List<Product> ajaxProductGetData(){
        List<Product> productList=productService.findAllProducts();
        return productList;
    }

    /**
     * 下拉框的ajax 请求
     * @return
     */
    //work/get_data
    @RequestMapping("work/get_data")
    @ResponseBody
    public List workGetData(){

        ArrayList resultList = new ArrayList();
        //map1.put("workId",)
        List<Task> allTasks = taskService.findAllTasks();
        for (Task task:
                allTasks) {
            HashMap map = new HashMap();
            String workId = task.getWorkId();
            map.put("workId",workId);
            resultList.add(map);
        }
        return resultList;

    }

    /**
     * 下拉框请求数据
     * @return
     */
    //manufacture/get_data
    @RequestMapping("manufacture/get_data")
    @ResponseBody
    public List manufactureGetData(){

        ArrayList resultList = new ArrayList();
        //map1.put("manufactureSn",)
        List<Task> allTasks = taskService.findAllTasks();
        for (Task task:
                allTasks) {
            HashMap map = new HashMap();
            String manufactureSn = task.getManufactureSn();
            map.put("manufactureSn",manufactureSn);
            resultList.add(map);
        }
        return resultList;

    }

    /**
     * 下拉框请求
     */

    @ResponseBody
    @RequestMapping("/process/get_data")
    public List processGetData(){
        //不重复处理
        List<Process> processes=processService.findAllProcess();
        ArrayList arrayList = new ArrayList();
        for (Process process:
                processes) {
            HashMap hashMap = new HashMap();
            hashMap.put("processId",process.getProcessId());
            hashMap.put("technologyPlanId",process.getTechnologyPlanId());
            hashMap.put("sequence",process.getSequence());
            hashMap.put("quota",process.getQuota());
            arrayList.add(hashMap);
        }
        return arrayList;

    }

//    @ResponseBody
//    @RequestMapping("/deviceList/get_data")
//    public Device[] deviceListGetData(){
//        //不重复处理
//        return deviceService.getData();
////        ArrayList arrayList = new ArrayList();
////        for (com.cskaoyan.domain.device.Device device:
////                deviceList) {
////            HashMap hashMap = new HashMap();
////            hashMap.put("deviceId",device.getDeviceId());
////            hashMap.put("deviceName",device.getDeviceName());
////            hashMap.put("deviceTypeId",device.getDeviceTypeId());
////            hashMap.put("deviceStatusId",device.getDeviceStatusId());
////            hashMap.put("deviceStatus",device.getDeviceStatus());
////            hashMap.put("devicePurchaseDate",device.getDevicePurchaseDate());
////            hashMap.put("devicePurchasePrice",device.getDevicePurchasePrice());
////            hashMap.put("deviceManufactureDate",device.getDeviceManufactureDate());
////            hashMap.put("deviceServiceLife",device.getDeviceServiceLife());
////            hashMap.put("deviceKeeperId",device.getDeviceKeeperId());
////            hashMap.put("note",device.getNote());
////
////            arrayList.add(hashMap);
////        }
//        //return arrayList;
//
//    }






}
