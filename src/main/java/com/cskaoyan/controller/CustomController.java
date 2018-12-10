package com.cskaoyan.controller;

import com.cskaoyan.domain.Custom;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Controller
public class CustomController {
    /**
     * 客户控制器
     */
    @Autowired
    CustomService customService;


    /**
     * 查看 select
     */
    @RequestMapping("custom/find")
    public String customFind(HttpSession session, HttpServletRequest request){
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "custom_list";
    }

    @ResponseBody
    @RequestMapping("custom/list")
    public Map customList(String page , String rows){
        HashMap hashMap = new HashMap();
        List<Custom> allCustom = customService.findAllCustom();
        hashMap.put("total",allCustom.size());
        hashMap.put("rows",allCustom);
        return  hashMap;
    }
    /**
     * 增加客户表 add
     */

    @ResponseBody
    @RequestMapping("custom/add_judge")
    public Map customAddJudge(){
        //权限管理

        return new HashMap();
    }

    @RequestMapping("custom/add")
    public String customAdd(){

        return "custom_add";
    }

    @RequestMapping("custom/insert")
    @ResponseBody
    //{"status":200,"msg":"OK","data":null}
    public Map customInsert(Custom custom){
        HashMap hashMap = new HashMap();
        boolean b =customService.addCustom(custom);
        if (b){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);

        }else {
            hashMap.put("status",100);
            hashMap.put("msg","is error");
            hashMap.put("data",null);

        }
        return  hashMap;

    }

    /**
     * 编辑 edit
     */

    @ResponseBody
    @RequestMapping("custom/edit_judge")
    public Map customEditJudge(){
        //权限校验

        return  new HashMap();
    }

    @RequestMapping("custom/edit")
    public String coustomEdit(){


        return "custom_edit";
    }
    @ResponseBody
    @RequestMapping("custom/update_all")
    public Map coustomUpdateAll(Custom custom){
        HashMap hashMap = new HashMap();
        boolean b =customService.updateCustom(custom);
        if (b){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);

        }else {
            hashMap.put("status",100);
            hashMap.put("msg","is error");
            hashMap.put("data",null);

        }
        return hashMap;
    }

    /**
     * 删除操作 delete
     */
    @ResponseBody
    @RequestMapping("custom/delete_judge")
    public Map customDeleteJudge(){
        //权限管理


        return new HashMap();
    }
    @ResponseBody
    @RequestMapping("custom/delete_batch")
    public Map customDeleteBatch(String[] ids){
        HashMap hashMap = new HashMap();
        boolean b = true;
        for (String id:
             ids) {

            b=customService.deleteById(id);
            if (b==false){
                break;
            }
        }
        if (b){
            hashMap.put("status",200);
            hashMap.put("msg","OK");
            hashMap.put("data",null);

        }else {
            hashMap.put("status",100);
            hashMap.put("msg","is error");
            hashMap.put("data",null);

        }

        return hashMap;

    }

    /**
     * 多条件查询
     */
    // /production_erp/custom/search_custom_by_customId
    // /production_erp/custom/search_custom_by_customName

    @ResponseBody
    @RequestMapping("/custom/{searchId}")
    public Map customSearch(String page , String rows, @PathVariable("searchId")String searchId,String searchValue){
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (searchId.equals("search_custom_by_customId")){
            Custom customById = customService.findCustomById(searchValue);
            arrayList.add(customById);
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }
        if (searchId.equals("search_custom_by_customName")){
            Custom customByName = customService.findCustomByName(searchValue);
            arrayList.add(customByName);
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);
        }
        return hashMap;

    }











}
