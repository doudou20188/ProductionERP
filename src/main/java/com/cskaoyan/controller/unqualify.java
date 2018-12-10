package com.cskaoyan.controller;

import com.cskaoyan.domain.*;
import com.cskaoyan.domain.VO.*;
import com.cskaoyan.domain.c_order;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cskaoyan.service.unqualifyService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class unqualify {
    @Autowired
    unqualifyService unqualifyService;

    /*下面是不合格品管理的增删改查代码*/
    @RequestMapping("unqualify/find")
    public String unqualify_find() {
        return "unqualify_list";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public unqualify_listVO unqualify_list() {


        List<unqualify_applyVO> unqualify_applyVO = new ArrayList<>();
        List<unqualify_apply> unqualify_apply1 = unqualifyService.selectAllQualify();

        if (unqualify_apply1 != null) {
            for (unqualify_apply x : unqualify_apply1) {
                unqualify_applyVO unqualify_applyVO1 = new unqualify_applyVO();
                String empId = x.getEmpId();
                String productId = x.getProductId();


                unqualify_applyVO1.setUnqualifyApplyId(x.getUnqualifyApplyId());
                unqualify_applyVO1.setProductId(x.getProductId());
                unqualify_applyVO1.setUnqualifyItem(x.getUnqualifyItem());
                unqualify_applyVO1.setUnqualifyCount(x.getUnqualifyCount());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setNote(x.getNote());

                String empName = unqualifyService.selectempNameById(empId);
                String productName = unqualifyService.selectproductNameById(productId);
                unqualify_applyVO1.setEmpName(empName);
                unqualify_applyVO1.setProductName(productName);
                unqualify_applyVO.add(unqualify_applyVO1);
            }
            unqualify_applyVO[] unqualify_applies = new unqualify_applyVO[unqualify_apply1.size()];
            String x = String.valueOf(unqualify_applyVO.size());

            unqualify_applyVO.toArray(unqualify_applies);
            unqualify_listVO unqualify_list1 = new unqualify_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }

    @RequestMapping("department/get_data")
    @ResponseBody
    public List<department> get_data() {
        List<department> departments = unqualifyService.selectAllDepartment();
        if (departments != null) {

            return departments;
        }

        return null;

    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String unqualify_add_judge() {

        return null;

    }


    @RequestMapping("unqualify/add")
    public String unqualify_add() {

        return "unqualify_add";

    }

    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<employee> employee_get_data() {
        List<employee> employees = unqualifyService.selectAllEmployee();
        return employees;

    }

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<product> product_get_data() {
        List<product> products = unqualifyService.selectAllProduct();
        return products;
    }

    @RequestMapping("unqualify/insert")
    @ResponseBody
    public Map unqualify_insert(HttpServletRequest request) {

        String unqualifyApplyId = request.getParameter("unqualifyApplyId");
        String productid = request.getParameter("productId");
        String unqualifyItem = request.getParameter("unqualifyItem");
        String unqualifyCount1 = request.getParameter("unqualifyCount");
        Integer unqualifyCount = Integer.parseInt(unqualifyCount1);
        String assemblyDate = request.getParameter("assemblyDate");
        String empid = request.getParameter("empId");
        String applyDate = request.getParameter("applyDate");
        String note = request.getParameter("note");

        unqualify_apply newunqualify_apply = new unqualify_apply();

        newunqualify_apply.setUnqualifyApplyId(unqualifyApplyId);

        newunqualify_apply.setProductId(productid);

        newunqualify_apply.setUnqualifyCount(unqualifyCount);
        newunqualify_apply.setUnqualifyItem(unqualifyItem);
        newunqualify_apply.setAssemblyDate(assemblyDate);

        newunqualify_apply.setEmpId(empid);

        newunqualify_apply.setApplyDate(applyDate);
        newunqualify_apply.setNote(note);
        int x1 = unqualifyService.addUnqualify_apply(newunqualify_apply);

        if (x1 == 1) {
            List<unqualify_applyVO> unqualify_applyVO = new ArrayList<>();
            List<unqualify_apply> unqualify_apply1 = unqualifyService.selectAllQualify();

            if (unqualify_apply1 != null) {
                for (unqualify_apply x : unqualify_apply1) {
                    unqualify_applyVO unqualify_applyVO1 = new unqualify_applyVO();
                    String empId = x.getEmpId();
                    String productId = x.getProductId();


                    unqualify_applyVO1.setUnqualifyApplyId(x.getUnqualifyApplyId());
                    unqualify_applyVO1.setProductId(x.getProductId());
                    unqualify_applyVO1.setUnqualifyItem(x.getUnqualifyItem());
                    unqualify_applyVO1.setUnqualifyCount(x.getUnqualifyCount());
                    unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                    unqualify_applyVO1.setEmpId(x.getEmpId());
                    unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                    unqualify_applyVO1.setNote(x.getNote());

                    String empName = unqualifyService.selectempNameById(empId);
                    String productName = unqualifyService.selectproductNameById(productId);
                    unqualify_applyVO1.setEmpName(empName);
                    unqualify_applyVO1.setProductName(productName);
                    unqualify_applyVO.add(unqualify_applyVO1);
                }

                unqualify_applyVO[] unqualify_applies = new unqualify_applyVO[unqualify_apply1.size()];
                String x = String.valueOf(unqualify_applyVO.size());

                unqualify_applyVO.toArray(unqualify_applies);
                unqualify_listVO unqualify_list1 = new unqualify_listVO();
                unqualify_list1.setRows(unqualify_applies);
                unqualify_list1.setTotal(x);


                Map map = new HashMap();
                map.put("status", 200);
                map.put("msg", "OK");
                map.put("data", "null");
                return map;
            }
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;
        }
        return null;
    }

    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public String unqualify_edit_judge() {

        return null;
    }

    @RequestMapping("unqualify/edit")
    public String unqualify_edit() {

        return "unqualify_edit";
    }

    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public Map unqualify_update_all(unqualify_apply unqualify_apply2) {
        int unqualifySize = unqualifyService.updateUnqualify_applyByunqualify(unqualify_apply2);

        if (unqualifySize == 1) {

            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }

    /*删除*/
    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public Map unqualify_delete_judge() {


        return null;

    }

    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public Map unqualify_delete_batch(String ids) {

        System.out.println(ids);

        int unqualifySize = unqualifyService.deleteUnqualify_applyByunqualify(ids);
        if (unqualifySize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            return null;
        }

    }

    /*查找*/
    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public unqualify_listVO unqualify_search_unqualify_by_unqualifyId(String searchValue) {
        List<unqualify_applyVO> unqualify_applyVO = new ArrayList<>();
        List<unqualify_apply> unqualify_apply1 = unqualifyService.selectQualifyById(searchValue);

        if (unqualify_apply1 != null) {
            for (unqualify_apply x : unqualify_apply1) {
                unqualify_applyVO unqualify_applyVO1 = new unqualify_applyVO();
                String empId = x.getEmpId();
                String productId = x.getProductId();


                unqualify_applyVO1.setUnqualifyApplyId(x.getUnqualifyApplyId());
                unqualify_applyVO1.setProductId(x.getProductId());
                unqualify_applyVO1.setUnqualifyItem(x.getUnqualifyItem());
                unqualify_applyVO1.setUnqualifyCount(x.getUnqualifyCount());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setNote(x.getNote());

                String empName = unqualifyService.selectempNameById(empId);
                String productName = unqualifyService.selectproductNameById(productId);
                unqualify_applyVO1.setEmpName(empName);
                unqualify_applyVO1.setProductName(productName);
                unqualify_applyVO.add(unqualify_applyVO1);
            }
            unqualify_applyVO[] unqualify_applies = new unqualify_applyVO[unqualify_apply1.size()];
            String x = String.valueOf(unqualify_applyVO.size());

            unqualify_applyVO.toArray(unqualify_applies);
            unqualify_listVO unqualify_list1 = new unqualify_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }

    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public unqualify_listVO unqualify_search_unqualify_by_productName(String searchValue) {
        List<unqualify_applyVO> unqualify_applyVO = new ArrayList<>();
        String searchId = unqualifyService.selectProductIdByproductname(searchValue);
        List<unqualify_apply> unqualify_apply1 = unqualifyService.selectQualifyByproductId(searchId);

        if (unqualify_apply1 != null) {
            for (unqualify_apply x : unqualify_apply1) {
                unqualify_applyVO unqualify_applyVO1 = new unqualify_applyVO();
                String empId = x.getEmpId();
                String productId = x.getProductId();


                unqualify_applyVO1.setUnqualifyApplyId(x.getUnqualifyApplyId());
                unqualify_applyVO1.setProductId(x.getProductId());
                unqualify_applyVO1.setUnqualifyItem(x.getUnqualifyItem());
                unqualify_applyVO1.setUnqualifyCount(x.getUnqualifyCount());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setNote(x.getNote());

                String empName = unqualifyService.selectempNameById(empId);
                String productName = unqualifyService.selectproductNameById(productId);
                unqualify_applyVO1.setEmpName(empName);
                unqualify_applyVO1.setProductName(productName);
                unqualify_applyVO.add(unqualify_applyVO1);
            }
            unqualify_applyVO[] unqualify_applies = new unqualify_applyVO[unqualify_apply1.size()];
            String x = String.valueOf(unqualify_applyVO.size());

            unqualify_applyVO.toArray(unqualify_applies);
            unqualify_listVO unqualify_list1 = new unqualify_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }
    /*下面是成品计量质检*/

    @RequestMapping("measure/find")

    public String measure_find() {
        return "measurement_list";
    }


    @RequestMapping("measure/list")
    @ResponseBody
    public final_measuret_listVO measure_list() {
        List<final_measuret_checkVO> final_measuret_checkVO = new ArrayList<>();
        List<final_measuret_check> unqualify_apply1 = unqualifyService.selectAllfinal_measuret_check();

        if (unqualify_apply1 != null) {
            for (final_measuret_check x : unqualify_apply1) {
                final_measuret_checkVO unqualify_applyVO1 = new final_measuret_checkVO();


                unqualify_applyVO1.setCdate(x.getCdate());
                unqualify_applyVO1.setCheckItem(x.getCheckItem());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setMeasureData(x.getMeasureData());
                unqualify_applyVO1.setNote(x.getNote());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setOrderId(x.getOrderId());
                unqualify_applyVO1.setfMeasureCheckId(x.getfMeasureCheckId());
                unqualify_applyVO1.setResult(x.getResult());

                unqualify_applyVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_measuret_checkVO.add(unqualify_applyVO1);
            }
            final_measuret_checkVO[] unqualify_applies = new final_measuret_checkVO[unqualify_apply1.size()];
            String x = String.valueOf(final_measuret_checkVO.size());

            final_measuret_checkVO.toArray(unqualify_applies);
            final_measuret_listVO unqualify_list1 = new final_measuret_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<custom> custom_get_data() {
        List<custom> customs = unqualifyService.selectAllCustom();
        if (customs != null) {
            return customs;
        }
        return null;
    }

    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String fMeasureCheck_add_judge() {

        return null;

    }

    @RequestMapping("measure/add")
    public String measure_add() {

        return "measurement_add";
    }

    @RequestMapping("product/get/{id}")
    @ResponseBody
    public product product_get_id(@PathVariable String id) {
        product product = unqualifyService.selectProductByProductId(id);
        return product;

    }

    @RequestMapping("employee/get/{id}")
    @ResponseBody
    public employee employee_get_id(@PathVariable String id) {
        employee employee = unqualifyService.selectemployeeByEmployeeId(id);
        return employee;

    }

    @RequestMapping("order/get/{id}")
    @ResponseBody
    public c_order order_get_id(@PathVariable String id) {

        return unqualifyService.selectC_orderByOrderId(id);

    }

    @RequestMapping("order/get_data")
    @ResponseBody
    public List<c_order> order_get_data() {
        List<c_order> c_orders = unqualifyService.selectAllC_order();
        return c_orders;
    }

    @RequestMapping("measure/insert")
    @ResponseBody
    public Map measure_insert(final_measuret_check final_measuret_check) {
        int unqualifySize = unqualifyService.insertfinal_measuret_checkByfinal_measuret(final_measuret_check);

        if (unqualifySize == 1) {

            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }
    /*编辑*/

    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String fMeasureCheck_edit_judge() {

        return null;
    }

    @RequestMapping("measure/edit")
    public String measure_edit() {

        return "measurement_edit";
    }

    @RequestMapping("measure/update_all")
    @ResponseBody
    public Map measure_update_all(final_measuret_check final_measuret_check) {
        int final_measuret_checkSize = unqualifyService.updatefinal_measuret_checkByfinal_measuret(final_measuret_check);

        if (final_measuret_checkSize == 1) {

            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }


    /*删除*/
    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public Map fMeasureCheck_delete_judge() {
        return null;
    }

    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public Map measure_delete_batch(String ids) {
        System.out.println(ids);

        int measureSize = unqualifyService.deletemeasureByMeasureId(ids);
        if (measureSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            return null;
        }

    }

    /*查找*/
    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public final_measuret_listVO measure_search_fMeasureCheck_by_fMeasureCheckId(String searchValue) {
        List<final_measuret_checkVO> final_measuret_checkVO = new ArrayList<>();
        List<final_measuret_check> final_measuret_check1 = unqualifyService.selectMeasureById(searchValue);

        if (final_measuret_check1 != null) {
            for (final_measuret_check x : final_measuret_check1) {
                final_measuret_checkVO unqualify_applyVO1 = new final_measuret_checkVO();
                unqualify_applyVO1.setCdate(x.getCdate());
                unqualify_applyVO1.setCheckItem(x.getCheckItem());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setMeasureData(x.getMeasureData());
                unqualify_applyVO1.setNote(x.getNote());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setOrderId(x.getOrderId());
                unqualify_applyVO1.setfMeasureCheckId(x.getfMeasureCheckId());
                unqualify_applyVO1.setResult(x.getResult());

                unqualify_applyVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_measuret_checkVO.add(unqualify_applyVO1);
            }
            final_measuret_checkVO[] unqualify_applies = new final_measuret_checkVO[final_measuret_check1.size()];
            String x = String.valueOf(final_measuret_checkVO.size());

            final_measuret_checkVO.toArray(unqualify_applies);
            final_measuret_listVO unqualify_list1 = new final_measuret_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }

    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public final_measuret_listVO measure_search_fMeasureCheck_by_orderId(String searchValue) {
        List<final_measuret_checkVO> final_measuret_checkVO = new ArrayList<>();
        List<final_measuret_check> final_measuret_check1 = unqualifyService.selectC_orderfromMeasuretByOrderId(searchValue);

        if (final_measuret_check1 != null) {
            for (final_measuret_check x : final_measuret_check1) {
                final_measuret_checkVO unqualify_applyVO1 = new final_measuret_checkVO();
                unqualify_applyVO1.setCdate(x.getCdate());
                unqualify_applyVO1.setCheckItem(x.getCheckItem());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setMeasureData(x.getMeasureData());
                unqualify_applyVO1.setNote(x.getNote());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setOrderId(x.getOrderId());
                unqualify_applyVO1.setfMeasureCheckId(x.getfMeasureCheckId());
                unqualify_applyVO1.setResult(x.getResult());

                unqualify_applyVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_measuret_checkVO.add(unqualify_applyVO1);
            }
            final_measuret_checkVO[] unqualify_applies = new final_measuret_checkVO[final_measuret_check1.size()];
            String x = String.valueOf(final_measuret_checkVO.size());

            final_measuret_checkVO.toArray(unqualify_applies);
            final_measuret_listVO unqualify_list1 = new final_measuret_listVO();
            unqualify_list1.setRows(unqualify_applies);
            unqualify_list1.setTotal(x);
            return unqualify_list1;
        }

        return null;
    }


    /*下面是成品计数质检*/
    /*这个地方是显示界面*/
    @RequestMapping("f_count_check/find")

    public String f_count_check_find() {
        return "f_count_check_list";
    }

    @RequestMapping("f_count_check/list")
    @ResponseBody
    public final_count_listVO f_count_check_list() {
        List<final_count_checkVO> final_count_checkVO = new ArrayList<>();
        List<final_count_check> final_count_check1 = unqualifyService.selectAllfinal_count_check();

        if (final_count_check1 != null) {
            for (final_count_check x : final_count_check1) {
                final_count_checkVO final_count_checkVO1 = new final_count_checkVO();


                final_count_checkVO1.setCdate(x.getCdate());
                final_count_checkVO1.setCheckItem(x.getCheckItem());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setMeasureData(x.getMeasureData());
                final_count_checkVO1.setNote(x.getNote());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setOrderId(x.getOrderId());
                final_count_checkVO1.setResult(x.getResult());
                final_count_checkVO1.setCheckNumber(x.getCheckNumber());
                final_count_checkVO1.setfCountCheckId(x.getfCountCheckId());
                final_count_checkVO1.setQualify(x.getQualify());
                final_count_checkVO1.setSample(x.getSample());
                final_count_checkVO1.setUnqualify(x.getUnqualify());

                final_count_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_count_checkVO.add(final_count_checkVO1);
            }
            final_count_checkVO[] unqualify_applies = new final_count_checkVO[final_count_check1.size()];
            String x = String.valueOf(final_count_checkVO.size());

            final_count_checkVO.toArray(unqualify_applies);
            final_count_listVO final_count_list1 = new final_count_listVO();
            final_count_list1.setRows(unqualify_applies);
            final_count_list1.setTotal(x);
            return final_count_list1;
        }
        return null;
    }
    /*新增界面*/

    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String fCountCheck_add_judge() {
        return null;
    }

    @RequestMapping("f_count_check/add")
    public String f_count_check_add() {

        return "f_count_check_add";
    }

    @RequestMapping("process/get_data")
    @ResponseBody
    public List<process> process_get_data() {
        List<process> processes = unqualifyService.selectAllProcess();
        return processes;
    }

    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public Map f_count_check_insert(final_count_check final_count_check) {
        System.out.println(final_count_check);
        int final_count_checkSize = unqualifyService.insertFinal_count_checkByfinal_count(final_count_check);

        if (final_count_checkSize == 1) {

            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }

    /*编辑*/

    @RequestMapping("fCountCheck/edit_judge")
    @ResponseBody
    public String fCountCheck_edit_judge() {

        return null;
    }

    @RequestMapping("f_count_check/edit")
    public String f_count_check_edit() {

        return "f_count_check_edit";
    }

    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public Map f_count_check_update_all(final_count_check final_count_check) {
        int final_count_checkSize = unqualifyService.updatefinal_count_checkByfinal_count(final_count_check);
        if (final_count_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }


    /*删除*/
    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public Map fCountCheck_delete_judge() {
        return null;
    }

    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public Map f_count_check_delete_batch(String ids) {
        System.out.println(ids);

        int final_count_checkSize = unqualifyService.deleteFinal_count_checkByfinal_countId(ids);
        if (final_count_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            return null;
        }

    }

    /*查找*/
    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public final_count_listVO f_count_check_search_fCountCheck_by_fCountCheckId(String searchValue) {
        List<final_count_checkVO> final_count_checkVO = new ArrayList<>();
        List<final_count_check> final_count_check1 = unqualifyService.selectfinal_count_checkByfCountCheckId(searchValue);

        if (final_count_check1 != null) {
            for (final_count_check x : final_count_check1) {
                final_count_checkVO final_count_checkVO1 = new final_count_checkVO();


                final_count_checkVO1.setCdate(x.getCdate());
                final_count_checkVO1.setCheckItem(x.getCheckItem());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setMeasureData(x.getMeasureData());
                final_count_checkVO1.setNote(x.getNote());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setOrderId(x.getOrderId());
                final_count_checkVO1.setResult(x.getResult());
                final_count_checkVO1.setCheckNumber(x.getCheckNumber());
                final_count_checkVO1.setfCountCheckId(x.getfCountCheckId());
                final_count_checkVO1.setQualify(x.getQualify());
                final_count_checkVO1.setSample(x.getSample());
                final_count_checkVO1.setUnqualify(x.getUnqualify());

                final_count_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_count_checkVO.add(final_count_checkVO1);
            }
            final_count_checkVO[] unqualify_applies = new final_count_checkVO[final_count_check1.size()];
            String x = String.valueOf(final_count_checkVO.size());

            final_count_checkVO.toArray(unqualify_applies);
            final_count_listVO final_count_list1 = new final_count_listVO();
            final_count_list1.setRows(unqualify_applies);
            final_count_list1.setTotal(x);
            return final_count_list1;
        }

        return null;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public final_count_listVO f_count_check_search_fCountCheck_by_orderId(String searchValue) {
        List<final_count_checkVO> final_count_checkVO = new ArrayList<>();
        List<final_count_check> final_count_check1 = unqualifyService.selectfinal_count_checkByorderId(searchValue);

        if (final_count_check1 != null) {
            for (final_count_check x : final_count_check1) {
                final_count_checkVO final_count_checkVO1 = new final_count_checkVO();


                final_count_checkVO1.setCdate(x.getCdate());
                final_count_checkVO1.setCheckItem(x.getCheckItem());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setMeasureData(x.getMeasureData());
                final_count_checkVO1.setNote(x.getNote());
                final_count_checkVO1.setEmpId(x.getEmpId());
                final_count_checkVO1.setOrderId(x.getOrderId());
                final_count_checkVO1.setResult(x.getResult());
                final_count_checkVO1.setCheckNumber(x.getCheckNumber());
                final_count_checkVO1.setfCountCheckId(x.getfCountCheckId());
                final_count_checkVO1.setQualify(x.getQualify());
                final_count_checkVO1.setSample(x.getSample());
                final_count_checkVO1.setUnqualify(x.getUnqualify());

                final_count_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                final_count_checkVO.add(final_count_checkVO1);
            }
            final_count_checkVO[] unqualify_applies = new final_count_checkVO[final_count_check1.size()];
            String x = String.valueOf(final_count_checkVO.size());

            final_count_checkVO.toArray(unqualify_applies);
            final_count_listVO final_count_list1 = new final_count_listVO();
            final_count_list1.setRows(unqualify_applies);
            final_count_list1.setTotal(x);
            return final_count_list1;
        }

        return null;
    }


    /*工序计量质检*/
    /*这个地方是显示界面*/
    @RequestMapping("p_measure_check/find")

    public String p_measure_check_find() {
        return "p_measure_check_list";
    }

    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public process_measure_listVO p_measure_check_list() {
        List<process_measure_checkVO> process_measure_checkVO = new ArrayList<>();
        List<process_measure_check> process_measure_check1 = unqualifyService.selectAllProcess_measure_check();

        if (process_measure_check1 != null) {
            for (process_measure_check x : process_measure_check1) {
                process_measure_checkVO process_measure_checkVO1 = new process_measure_checkVO();


                process_measure_checkVO1.setCdate(x.getCdate());
                process_measure_checkVO1.setCheckItem(x.getCheckItem());
                process_measure_checkVO1.setEmpId(x.getEmpId());
                process_measure_checkVO1.setMeasureData(x.getMeasureData());
                process_measure_checkVO1.setNote(x.getNote());
                process_measure_checkVO1.setEmpId(x.getEmpId());
                process_measure_checkVO1.setProcessId(x.getProcessId());
                process_measure_checkVO1.setResult(x.getResult());
                process_measure_checkVO1.setpMeasureCheckId(x.getpMeasureCheckId());


                process_measure_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                process_measure_checkVO.add(process_measure_checkVO1);
            }
            process_measure_checkVO[] unqualify_applies = new process_measure_checkVO[process_measure_check1.size()];
            String x = String.valueOf(process_measure_checkVO.size());

            process_measure_checkVO.toArray(unqualify_applies);
            process_measure_listVO process_measure_listVO1 = new process_measure_listVO();
            process_measure_listVO1.setRows(unqualify_applies);
            process_measure_listVO1.setTotal(x);
            return process_measure_listVO1;
        }
        return null;
    }
    /*新增界面*/

    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public String pMeasureCheck_add_judge() {
        return null;
    }

    @RequestMapping("p_measure_check/add")
    public String p_measure_check_add() {

        return "p_measure_check_add";
    }

    @RequestMapping("technologyPlan/get_data")
    @ResponseBody
    public List<technology> technologyPlan_get_data() {
        List<technology> technologies = unqualifyService.selectAllTechnology();
        return technologies;
    }

    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public Map p_measure_check_insert(process_measure_check process_measure_check) {
        int process_measure_checkSize = unqualifyService.insertProcess_measure_checkByProcess_measure(process_measure_check);
        if (process_measure_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }

    /*编辑*/

    @RequestMapping("pMeasureCheck/edit_judge")
    @ResponseBody
    public String pMeasureCheck_edit_judge() {

        return null;
    }

    @RequestMapping("p_measure_check/edit")
    public String p_measure_check_edit() {

        return "p_measure_check_edit";
    }

    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public Map p_measure_check_update_all(process_measure_check process_measure_check) {
        int process_measure_checkSize = unqualifyService.updateProcess_measure_checkByProcess_measure(process_measure_check);
        if (process_measure_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }


    /*删除*/
    @RequestMapping("pMeasureCheck/delete_judge")
    @ResponseBody
    public Map pMeasureCheck_delete_judge() {
        return null;
    }

    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public Map p_measure_check_delete_batch(String ids) {
        int process_measure_checkSize = unqualifyService.deleteProcess_measure_checkByprocess_measure(ids);
        if (process_measure_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            return null;
        }

    }

    /*查找*/
    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public process_measure_listVO p_measure_check_search_pMeasureCheck_by_pMeasureCheckId(String searchValue) {
        List<process_measure_checkVO> process_measure_checkVO = new ArrayList<>();
        List<process_measure_check> process_measure_check1 = unqualifyService.selectprocess_measure_checkByprocess_measure(searchValue);

        if (process_measure_check1 != null) {
            for (process_measure_check x : process_measure_check1) {
                process_measure_checkVO process_measure_checkVO1 = new process_measure_checkVO();


                process_measure_checkVO1.setCdate(x.getCdate());
                process_measure_checkVO1.setCheckItem(x.getCheckItem());
                process_measure_checkVO1.setEmpId(x.getEmpId());
                process_measure_checkVO1.setMeasureData(x.getMeasureData());
                process_measure_checkVO1.setNote(x.getNote());
                process_measure_checkVO1.setEmpId(x.getEmpId());
                process_measure_checkVO1.setProcessId(x.getProcessId());
                process_measure_checkVO1.setResult(x.getResult());
                process_measure_checkVO1.setpMeasureCheckId(x.getpMeasureCheckId());


                process_measure_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                process_measure_checkVO.add(process_measure_checkVO1);
            }
            process_measure_checkVO[] unqualify_applies = new process_measure_checkVO[process_measure_check1.size()];
            String x = String.valueOf(process_measure_checkVO.size());

            process_measure_checkVO.toArray(unqualify_applies);
            process_measure_listVO process_measure_listVO1 = new process_measure_listVO();
            process_measure_listVO1.setRows(unqualify_applies);
            process_measure_listVO1.setTotal(x);
            return process_measure_listVO1;
        }

        return null;
    }


    /*工序计数质检*/
    /*这个地方是显示界面*/
    @RequestMapping("p_count_check/find")

    public String p_count_check_find() {
        return "p_count_check_list";
    }

    @RequestMapping("p_count_check/list")
    @ResponseBody
    public process_count_listVO p_count_check_list() {
        List<process_count_checkVO> process_count_checkVO = new ArrayList<>();
        List<process_count_check> process_count_check1 = unqualifyService.selectAllProcess_count_check();

        if (process_count_check1 != null) {
            for (process_count_check x : process_count_check1) {
                process_count_checkVO process_count_checkVO1 = new process_count_checkVO();


                process_count_checkVO1.setCdate(x.getCdate());
                process_count_checkVO1.setCheckItem(x.getCheckItem());
                process_count_checkVO1.setEmpId(x.getEmpId());
                process_count_checkVO1.setMeasureData(x.getMeasureData());
                process_count_checkVO1.setNote(x.getNote());
                process_count_checkVO1.setEmpId(x.getEmpId());
                process_count_checkVO1.setProcessId(x.getProcessId());
                process_count_checkVO1.setResult(x.getResult());
                process_count_checkVO1.setpCountCheckId(x.getpCountCheckId());
                process_count_checkVO1.setCheckNumber(x.getCheckNumber());
                process_count_checkVO1.setSample(x.getSample());
                process_count_checkVO1.setUnqualify(x.getUnqualify());
                process_count_checkVO1.setQualify(x.getQualify());


                process_count_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                process_count_checkVO.add(process_count_checkVO1);
            }
            process_count_checkVO[] unqualify_applies = new process_count_checkVO[process_count_check1.size()];
            String x = String.valueOf(process_count_checkVO.size());

            process_count_checkVO.toArray(unqualify_applies);
            process_count_listVO process_count_listVO1 = new process_count_listVO();
            process_count_listVO1.setRows(unqualify_applies);
            process_count_listVO1.setTotal(x);
            return process_count_listVO1;
        }
        return null;
    }

    /*新增界面*/

    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public String pCountCheck_add_judge() {
        return null;
    }

    @RequestMapping("p_count_check/add")
    public String p_count_check_add() {

        return "p_count_check_add";
    }


    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public Map p_count_check_insert(process_count_check process_count_check) {
        int process_count_checkSize = unqualifyService.insertProcess_count_checkByProcess_count(process_count_check);
        if (process_count_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }

    /*编辑*/


    @RequestMapping("pCountCheck/edit_judge")
    @ResponseBody
    public String  pCountCheck_edit_judge() {

        return null;
    }

    @RequestMapping("p_count_check/edit")
    public String p_count_check_edit() {

        return "p_count_check_edit";
    }

    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public Map p_count_check_update_all(process_count_check process_count_check) {
        int process_count_checkSize = unqualifyService.updateProcess_count_checkByProcess_count(process_count_check);
        if (process_count_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            Map map = new HashMap();
            map.put("status", 500);
            map.put("msg", "false");
            map.put("data", "false");
            return null;

        }
    }

    @RequestMapping("process/get/{id}")
    @ResponseBody
    public process process_get_id(@PathVariable String id) {

        return unqualifyService.selectProcessByProcessId(id);

    }

/*删除*/

    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public Map pCountCheck_delete_judge() {
        return null;
    }

    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public Map p_count_check_delete_batch(String ids) {
        int process_count_checkSize = unqualifyService.deleteProcess_count_checkByprocess_count(ids);
        if (process_count_checkSize == 1) {
            Map map = new HashMap();
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", "null");
            return map;
        } else {
            return null;
        }

    }


/*查找*/

    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public process_count_listVO p_count_check_search_pCountCheck_by_pCountCheckId(String searchValue) {
        List<process_count_checkVO> process_count_checkVO = new ArrayList<>();
        List<process_count_check> process_count_check1 = unqualifyService.selectprocess_count_checkByprocess_count(searchValue);

        if (process_count_check1 != null) {
            for (process_count_check x : process_count_check1) {
                process_count_checkVO process_count_checkVO1 = new process_count_checkVO();


                process_count_checkVO1.setCdate(x.getCdate());
                process_count_checkVO1.setCheckItem(x.getCheckItem());
                process_count_checkVO1.setEmpId(x.getEmpId());
                process_count_checkVO1.setMeasureData(x.getMeasureData());
                process_count_checkVO1.setNote(x.getNote());
                process_count_checkVO1.setEmpId(x.getEmpId());
                process_count_checkVO1.setProcessId(x.getProcessId());
                process_count_checkVO1.setResult(x.getResult());
                process_count_checkVO1.setpCountCheckId(x.getpCountCheckId());
                process_count_checkVO1.setCheckNumber(x.getCheckNumber());
                process_count_checkVO1.setSample(x.getSample());
                process_count_checkVO1.setUnqualify(x.getUnqualify());
                process_count_checkVO1.setQualify(x.getQualify());

                process_count_checkVO1.setEmpName(unqualifyService.selectempNameById(x.getEmpId()));
                process_count_checkVO.add(process_count_checkVO1);
            }
            process_count_checkVO[] unqualify_applies = new process_count_checkVO[process_count_check1.size()];
            String x = String.valueOf(process_count_checkVO.size());

            process_count_checkVO.toArray(unqualify_applies);
            process_count_listVO process_count_listVO1 = new process_count_listVO();
            process_count_listVO1.setRows(unqualify_applies);
            process_count_listVO1.setTotal(x);
            return process_count_listVO1;
        }
        return null;
    }




}


