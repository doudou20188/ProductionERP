package com.cskaoyan.controller.unqualify_applyVOController;

import com.cskaoyan.domain.unqualify_applyVO.unqualify_applyVO;
import com.cskaoyan.domain.unqualify_applyVO.unqualify_listVO;
import com.cskaoyan.domain.unqualify_apply.department;
import com.cskaoyan.domain.unqualify_apply.employee;
import com.cskaoyan.domain.unqualify_apply.product;
import com.cskaoyan.domain.unqualify_apply.unqualify_apply;
import com.cskaoyan.service.unqualify_applyService.unqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("unqualify/find")
    public String loginForm(){
            return  "unqualify_list";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public unqualify_listVO unqualify_list(){


        List<unqualify_applyVO> unqualify_applyVO=new ArrayList<>();
        List<unqualify_apply> unqualify_apply1 = unqualifyService.selectAllQualify();

        if(unqualify_apply1!=null){
            for(unqualify_apply x:unqualify_apply1){
               unqualify_applyVO unqualify_applyVO1 = new unqualify_applyVO();
                String empId=x.getEmpId();
               String productId=x.getProductId();


               unqualify_applyVO1.setUnqualifyApplyId(x.getUnqualifyApplyId());
                unqualify_applyVO1.setProductId(x.getProductId());
                unqualify_applyVO1.setUnqualifyItem(x.getUnqualifyItem());
                unqualify_applyVO1.setUnqualifyCount(x.getUnqualifyCount());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setEmpId(x.getEmpId());
                unqualify_applyVO1.setAssemblyDate(x.getAssemblyDate());
                unqualify_applyVO1.setNote(x.getNote());

                String empName=unqualifyService.selectempNameById(empId);
                String productName=unqualifyService.selectproductNameById(productId);
                unqualify_applyVO1.setEmpName(empName);
                unqualify_applyVO1.setProductName(productName);
                unqualify_applyVO.add(unqualify_applyVO1);
            }
            unqualify_applyVO[] unqualify_applies = new unqualify_applyVO[unqualify_apply1.size()];
            String x=String.valueOf(unqualify_applyVO.size()) ;

            unqualify_applyVO.toArray(unqualify_applies);
            unqualify_listVO unqualify_list1=new unqualify_listVO();
            unqualify_list1.setRows( unqualify_applies);
            unqualify_list1.setTotal(x);
            return  unqualify_list1;
        }

        return  null;
    }
    @RequestMapping("department/get_data")
    @ResponseBody
    public List<department> get_data(){
        List<department> departments = unqualifyService.selectAllDepartment();
        if(departments!=null){

            return  departments;
        }

        return  null;

    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String unqualify_add_judge(){

        return  null;

    }
    @RequestMapping("unqualify/add")
    public String unqualify_add(){

        return  "unqualify_add";

    }

    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<employee> employee_get_data(){
     List<employee> employees=unqualifyService.selectAllEmployee();
        return  employees;

    }

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<product>  product_get_data(){
        List<product> products=unqualifyService.selectAllProduct();
        return  products;
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

        if(x1==1) {
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
        }else{
        Map map = new HashMap();
        map.put("status", 500);
        map.put("msg", "false");
        map.put("data", "false");
        return null;
        }
        return  null;
    }
}
