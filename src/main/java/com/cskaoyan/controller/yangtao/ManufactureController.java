package com.cskaoyan.controller.yangtao;

import com.cskaoyan.domain.technology.Technology;
import com.cskaoyan.domain.yangtao.*;
import com.cskaoyan.service.technology.TechnologyService;
import com.cskaoyan.service.yangtao.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 生产计划管理控制器
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Controller
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    CorderService corderService;
    @Autowired
    TechnologyService technologyService;
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;



    @RequestMapping("manufacture/find")
    public ModelAndView manufactureFind( HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("manufacture_list");
        return modelAndView;

    }

    @ResponseBody
    @RequestMapping("manufacture/list")
    public Map AjaxList(String rows, String page){
        HashMap hashMap = new HashMap();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Manufacture> manufactureList= manufactureService.findAllManufacture();
        ArrayList arrayList = new ArrayList();
        for (Manufacture mm:
             manufactureList) {
            HashMap map = new HashMap();
            String orderId = mm.getOrderId();
            String technologyId = mm.getTechnologyId();
            Corder corder=corderService.findOrderById(orderId);
            Technology technology=technologyService.findTechnologyById(technologyId);
            map.put("manufactureSn",mm.getManufactureSn());
            map.put("launchQuantity",mm.getLaunchQuantity());
            map.put("beginDate",mm.getBeginDate());
            map.put("endDate",mm.getEndDate());
            map.put("cOrder",corder);
            map.put("technology",technology);
            arrayList.add(map);
        }
        hashMap.put("total",manufactureList.size());
        hashMap.put("rows",arrayList);

        return hashMap;

    }

    /**
     * 生产计划管理 add
     */
    @ResponseBody
    @RequestMapping("manufacture/add_judge")
    public Map manufactureAddJudge(){
        //权限控制工作

        return new HashMap();

    }
    @RequestMapping("/manufacture/add")
    public String manufactureAdd(){

        return "manufacture_add";
    }




    //manufacture/insert
    //{"status":200,"msg":"OK","data":null}
    @ResponseBody
    @RequestMapping("/manufacture/insert")
    public Map manfactureInsert(Manufacture manufacture){
        System.out.println(manufacture);
        HashMap map = new HashMap();
        boolean b=manufactureService.addManfacture(manufacture);
        if (b){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);

        }else {
            map.put("status",100);
            map.put("msg","have error");
            map.put("data",null);
        }
        return map;

    }
    /**
     * 删除delete
     */

    @ResponseBody
    @RequestMapping("manufacture/delete_judge")
    public Map manfactureDeleteJudge(){
        //权限控制模块

        return new HashMap();
    }

    @ResponseBody
    @RequestMapping("manufacture/delete_batch")
    public Map manfactureDelete(String[] ids){
        //权限控制模块
        System.out.println(Arrays.toString(ids));
        boolean b =false;
        HashMap map = new HashMap();
        for (String id:
             ids) {
           b=manufactureService.deleteManufactureById(id);
           if (b ==false){
               break;
           }
        }
        if (b){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }else {
            map.put("status",100);
            map.put("msg","have error");
            map.put("data",null);
        }

        return map;
    }

    /**
     * 更新操作 update
     */
    @ResponseBody
    @RequestMapping("manufacture/edit_judge")
    public Map manfactureEditJudge(){
        //权限控制模块
        return new HashMap();
    }

    @RequestMapping("manufacture/edit")
    public String manufactureEdit(){

        return "manufacture_edit";
    }

    @ResponseBody
    @RequestMapping("manufacture/update_all")
    public Map manfactureUpdateAll(Manufacture manufacture){
        HashMap map = new HashMap();
        boolean b =manufactureService.updateManufacture(manufacture);
        if (b){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }else {
            map.put("status",100);
            map.put("msg","have error");
            map.put("data",null);
        }
        return map;

    }
    /**
     * 多条件查询
     */
  /*  manufacture/search_manufacture_by_manufactureSn
    manufacture/search_manufacture_by_manufactureOrderId
    manufacture/search_manufacture_by_manufactureTechnologyName
    */
    @ResponseBody
    @RequestMapping("manufacture/{searchId}")
    public Map searchTaskByID(@PathVariable String searchId, String searchValue, String Page, String rows){
        HashMap hashMap = new HashMap();
        List manufactureList=new ArrayList();

        if (searchId.equals("search_manufacture_by_manufactureSn")){
          Manufacture manufacture = manufactureService.findManufactureById(searchValue);
            String orderId = manufacture.getOrderId();
            String technologyId = manufacture.getTechnologyId();
            Corder order = corderService.findOrderById(orderId);
            Technology technology = technologyService.findTechnologyById(technologyId);
            HashMap map = new HashMap();
            map.put("manufactureSn",manufacture.getManufactureSn());
            map.put("launchQuantity",manufacture.getLaunchQuantity());
            map.put("beginDate",manufacture.getBeginDate());
            map.put("endDate",manufacture.getEndDate());
            map.put("cOrder",order);
            map.put("technology",technology);
            manufactureList.add(map);

            hashMap.put("total",manufactureList.size());
            hashMap.put("rows",manufactureList);
        }
        if (searchId.equals("search_manufacture_by_manufactureOrderId")){
            List<Manufacture> manufactureListOrder=manufactureService.findManufactureByOrderId(searchValue);
            for (Manufacture mm:
                 manufactureListOrder) {
                String orderId = mm.getOrderId();
                String technologyId = mm.getTechnologyId();
                Corder orderById = corderService.findOrderById(orderId);
                Technology technologyById = technologyService.findTechnologyById(technologyId);
                HashMap map = new HashMap();
                map.put("manufactureSn",mm.getManufactureSn());
                map.put("launchQuantity",mm.getLaunchQuantity());
                map.put("beginDate",mm.getBeginDate());
                map.put("endDate",mm.getEndDate());
                map.put("cOrder",orderById);
                map.put("technology",technologyById);
                manufactureList.add(map);
            }
            hashMap.put("total",manufactureList.size());
            hashMap.put("rows",manufactureList);
        }
        if (searchId.equals("search_manufacture_by_manufactureTechnologyName")){
            //通过工艺名获取工艺id
            List<Technology> technologyByIdList = technologyService.findTechnologyByTechnologyName(searchValue);
            System.out.println(technologyByIdList);
            for (Technology tt:   //只有一个对象 foreach 之后优化
                 technologyByIdList) {
                String technologyId = tt.getTechnologyId();

                //Manufacture manufacture=manufactureService.findManutureByTechID(technologyId);
                List<Manufacture> manufactureByTeachnologyId = manufactureService.findManufactureByTeachnologyId(technologyId);
                for (Manufacture mm:
                manufactureByTeachnologyId) {

                    String orderId = mm.getOrderId();
                    String technologyId1 = mm.getTechnologyId();
                    Corder orderById1 = corderService.findOrderById(orderId);
                    Technology technologyById1 = technologyService.findTechnologyById(technologyId1);
                    HashMap map = new HashMap();
                    map.put("manufactureSn",mm.getManufactureSn());
                    map.put("launchQuantity",mm.getLaunchQuantity());
                    map.put("beginDate",mm.getBeginDate());
                    map.put("endDate",mm.getEndDate());
                    map.put("cOrder",orderById1);
                    map.put("technology",technologyById1);
                    manufactureList.add(map);
                }

            }
            hashMap.put("total",manufactureList.size());
            hashMap.put("rows",manufactureList);
        }
        return hashMap;
    }



















}
