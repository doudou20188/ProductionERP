package com.cskaoyan.controller.yangtao;



import com.cskaoyan.domain.technology.Processes;
import com.cskaoyan.domain.yangtao.Process;
import com.cskaoyan.domain.yangtao.Product;
import com.cskaoyan.domain.yangtao.Work;
import com.cskaoyan.service.devicr.DeviceService;
import com.cskaoyan.service.technology.ProcessService;
import com.cskaoyan.service.yangtao.ProductService;
import com.cskaoyan.service.yangtao.WorkService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作业管理控制器
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Controller
public class WorkController {
    @Autowired
    WorkService workService;
    @Autowired
    ProductService productService;
    @Autowired
    ProcessService processService;
    @Autowired
    DeviceService deviceService;


    /**
     * 显示 select
     */
    @RequestMapping("work/find")
    public String workFind(HttpSession session){
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "work_list";
    }
    @ResponseBody
    @RequestMapping("work/list")
    public Map workList(String page,String rows){
        HashMap hashMap = new HashMap();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Work> workList= workService.findAllWorks();

        ArrayList arrayList = new ArrayList();
        for (Work work:
             workList) {
            HashMap map = new HashMap();
            String productId = work.getProductId();
            String processId = work.getProcessId();
            String deviceId = work.getDeviceId();
            Product product = productService.findProductById(productId);
            Processes process=processService.findProcessById(processId);
            com.cskaoyan.domain.device.Device device=deviceService.get(deviceId);
            map.put("workId",work.getWorkId());
            map.put("processNumber",work.getProcessNumber());
            map.put("product",product);
            map.put("process",process);
            map.put("device",device);
            map.put("rating",work.getRating());
            arrayList.add(map);
        }
        hashMap.put("total",arrayList.size());
        hashMap.put("rows",arrayList);
        return hashMap;
    }

    /**
     * 增加操作 add
     */

    @ResponseBody
    @RequestMapping("work/add_judge")
    public Map workAddJudge(){
        //权限管理


        return new HashMap();
    }

    @RequestMapping("work/add")
    public String workAdd(){


        return "work_add";
    }

    @ResponseBody
    @RequestMapping("work/insert")
    public Map workInsert(Work work){
        HashMap map = new HashMap();
        boolean b =workService.addWork(work);
        if (b){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }else {
            map.put("status",100);
            map.put("msg","is error!");
            map.put("data",null);
        }
        return map;
    }
    /**
     * 编辑 edit
     */
    @ResponseBody
    @RequestMapping("work/edit_judge")
    public Map workEditJudge(){
        //权限管理
        return new HashMap();
    }

    @RequestMapping("work/edit")
    public String workEdit(){

        return "work_edit";
    }
    @ResponseBody
    @RequestMapping("/work/update_all")
    public Map workUpdateAll(Work work){
        HashMap map = new HashMap();

        boolean b =workService.updateWork(work);
        if (b){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }else{
            map.put("status",100);
            map.put("msg","is error!");
            map.put("data",null);
        }

        return map;
    }

    /**
     * 删除操作
     */
    @ResponseBody
    @RequestMapping("work/delete_judge")
    public Map workDeleteJudge(){
        //权限管理工作

        return new HashMap();
    }
    @ResponseBody
    @RequestMapping("work/delete_batch")
    public Map workDeleteBatch(String[] ids){
        HashMap map = new HashMap();
        boolean b =false;
        for (String id:
             ids) {

            b=workService.deleteWorkById(id);
            if (b==false){
                break;
            }
        }
        if (b) {
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);

        }else {
            map.put("status",100);
            map.put("msg","is error");
            map.put("data",null);

        }

        return map;
    }

    /**
     * 多条件查询
     */

    // /work/search_work_by_workId
    // /work/search_work_by_workProduct
    // /work/search_work_by_workDevice
    // /work/search_work_by_workProcess
    @ResponseBody
    @RequestMapping("/work/{searchId}")
    public Map workSearch(String page ,String rows ,String searchValue,@PathVariable("searchId") String searchId){
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (searchId.equals("search_work_by_workId")){
            HashMap map = new HashMap();
            Work work =workService.findWorkByWorkId(searchValue);
            String productId = work.getProductId();
            String processId = work.getProcessId();
            String deviceId = work.getDeviceId();
            Product product = productService.findProductById(productId);
            Processes process = processService.findProcessById(processId);
            com.cskaoyan.domain.device.Device device = deviceService.get(deviceId);
            map.put("workId",work.getWorkId());
            map.put("processNumber",work.getProcessNumber());
            map.put("product",product);
            map.put("process",process);
            map.put("device",device);
            map.put("rating",work.getRating());
            arrayList.add(map);
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);
        }
        if (searchId.equals("search_work_by_workProduct")){
            //可以有多个同名的产品，所以使用列表接收 也可以用单个对象接收 个人理解，不影响使用
            List<Product> productList = productService.findProductListByName(searchValue);
            for (Product product:
                 productList) {
                String theProductId = product.getProductId();
                List<Work>workList= workService.findWorklistByProductId(theProductId);
                for (Work work:
                     workList) {
                    HashMap map = new HashMap();
                    String productId = work.getProductId();
                    String processId = work.getProcessId();
                    String deviceId = work.getDeviceId();
                    Product product1 = productService.findProductById(productId);
                    Processes process1 = processService.findProcessById(processId);
                    com.cskaoyan.domain.device.Device device1 = deviceService.get(deviceId);

                    map.put("workId",work.getWorkId());
                    map.put("processNumber",work.getProcessNumber());
                    map.put("product",product1);
                    map.put("process",process1);
                    map.put("device",device1);
                    map.put("rating",work.getRating());
                    arrayList.add(map);
                }
            }

            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }

        if (searchId.equals("search_work_by_workDevice")){
            com.cskaoyan.domain.device.Device theDevice = deviceService.get(searchValue);
            String theDeviceId = theDevice.getDeviceId();
            List<Work> workList=workService.findWorklistByDeviceId(theDeviceId);
            for (Work work:
                 workList) {
                HashMap map = new HashMap();
                String productId = work.getProductId();
                String processId = work.getProcessId();
                String deviceId = work.getDeviceId();
                Product product1 = productService.findProductById(productId);
                Processes process1 = processService.findProcessById(processId);
                com.cskaoyan.domain.device.Device device1 = deviceService.get(deviceId);

                map.put("workId",work.getWorkId());
                map.put("processNumber",work.getProcessNumber());
                map.put("product",product1);
                map.put("process",process1);
                map.put("device",device1);
                map.put("rating",work.getRating());
                arrayList.add(map);
            }
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }

        if (searchId.equals("search_work_by_workProcess")){
            List<Work> workList=workService.findWorkListByProcessId(searchValue);
            for (Work work:
                 workList) {
                HashMap map = new HashMap();
                String productId = work.getProductId();
                String processId = work.getProcessId();
                String deviceId = work.getDeviceId();
                Product product1 = productService.findProductById(productId);
                Processes process1 = processService.findProcessById(processId);
                com.cskaoyan.domain.device.Device device1 = deviceService.get(deviceId);

                map.put("workId",work.getWorkId());
                map.put("processNumber",work.getProcessNumber());
                map.put("product",product1);
                map.put("process",process1);
                map.put("device",device1);
                map.put("rating",work.getRating());
                arrayList.add(map);
            }
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);


        }




        return hashMap;
    }













}
