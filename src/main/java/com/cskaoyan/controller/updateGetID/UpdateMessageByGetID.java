package com.cskaoyan.controller.updateGetID;

import com.cskaoyan.domain.yangtao.*;
import com.cskaoyan.domain.yangtao.Process;
import com.cskaoyan.service.yangtao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: YangTao
 * @Date: 2018/12/10 0010
 */
@Controller
public class UpdateMessageByGetID {
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;
    @Autowired
    ProcessService processService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    CorderService corderService;
    @Autowired
    TechnologyService technologyService;
    @Autowired
    WorkService workService;
    @Autowired
    ManufactureService manufactureService;


    @ResponseBody
    @RequestMapping("/custom/get/{theNumId}")
    public Custom updateCustomGetID(@PathVariable("theNumId")String theNumId){
        Custom customById = customService.findCustomById(theNumId);
        return customById;
    }
    @ResponseBody
    @RequestMapping("product/get/{theNumId}")
    public Product updateProjectGetID(@PathVariable("theNumId")String theNumId){
        Product productById = productService.findProductById(theNumId);
        return productById;

    }
    @ResponseBody
    @RequestMapping("process/get/{theNumId}")
    public Process updateProcessGetID(@PathVariable("theNumId")String theNumId){
        Process processById = processService.findProcessById(theNumId);
        return processById;


    }
    @ResponseBody
    @RequestMapping("/deviceList/get/{theNumId}")
    public Device updateDeviceGetID(@PathVariable("theNumId")String theNumId){
        Device deviceById = deviceService.findDeviceById(theNumId);
        return deviceById;
    }
    @ResponseBody
    @RequestMapping("/order/get/{theNumId}")
    public Corder updateOrderGetID(@PathVariable("theNumId")String theNumId){
        Corder orderById = corderService.findOrderById(theNumId);
        return orderById;
    }
    @ResponseBody
    @RequestMapping("technology/get/{theNumId}")
    public Technology updateTechnologyGetID(@PathVariable("theNumId")String theNumId){
        Technology technologyById = technologyService.findTechnologyById(theNumId);
        return technologyById;
    }
    @ResponseBody
    @RequestMapping("/work/get/{theNumId}")
    public Work updateWorkGetID(@PathVariable("theNumId")String theNumId){
        Work workByWorkId = workService.findWorkByWorkId(theNumId);
        return workByWorkId;

    }

    @ResponseBody
    @RequestMapping("/manufacture/{theNumId}")
    public Manufacture updateManufactureGetID(@PathVariable("theNumId")String theNumId){
        Manufacture manufactureById = manufactureService.findManufactureById(theNumId);
        return manufactureById;

    }









}
