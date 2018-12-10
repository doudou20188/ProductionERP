package com.cskaoyan.controller.yangtao;

import com.cskaoyan.domain.yangtao.Corder;
import com.cskaoyan.domain.yangtao.Custom;
import com.cskaoyan.domain.yangtao.Product;
import com.cskaoyan.service.yangtao.CorderService;
import com.cskaoyan.service.yangtao.CustomService;
import com.cskaoyan.service.yangtao.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: YangTao
 * @Date: 2018/12/8 0008
 */
@Controller
public class OrderController {
    @Autowired
    CorderService corderService;
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;


    /**
     * 查找select
     */
    @RequestMapping("order/find")
    public String  orderFind(HttpSession session){
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("order/list")
    public Map ajaxOrderList(String page ,String rows){
        HashMap hashMap = new HashMap();

        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Corder> allOrder = corderService.findAllOrder();
        //System.out.println(allOrder.size());
        ArrayList arrayList = new ArrayList();
        for (Corder order:
                allOrder) {
            HashMap map = new HashMap();
            String customId = order.getCustomId();
            String productId = order.getProductId();
            Custom custom=customService.findCustomById(customId);
            Product product=productService.findProductById(productId);
            map.put("orderId",order.getOrderId());
            map.put("orderDate",order.getOrderDate());
            map.put("requestDate",order.getRequestDate());
            map.put("note",order.getNote());
            map.put("quantity",order.getQuantity());
            map.put("unitPrice",order.getUnit());
            map.put("unit",order.getUnit());
            map.put("image",order.getImage());
            map.put("file",order.getFile());
            map.put("status",order.getStatus());
            map.put("custom",custom);
            map.put("product",product);
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
    @RequestMapping("order/add_judge")
    public Map orderAddJudge(){
        //权限管理


        return new HashMap();
    }

    @RequestMapping("order/add")
    public String orderAdd(){

        return "order_add";
    }
    /**
     * 图片上传
     */
    //{"error":0,"url":"/pic/1544302835765264.jpg"}

    @ResponseBody
    @RequestMapping("pic/upload")
    public Map theFileUpload(MultipartFile uploadFile , String dir, HttpServletRequest request) throws IOException {
        HashMap hashMap = new HashMap();
        //处理图片
        String realPath = request.getServletContext().getRealPath("/pic");
        System.out.println(realPath+"66666666666");
        String originalFilename = uploadFile.getOriginalFilename();
        File file = new File(realPath + "/" + originalFilename);
        uploadFile.transferTo(file);
        hashMap.put("error",0);
        hashMap.put("url","/pic"+"/"+originalFilename);


        return hashMap;

    }
    @ResponseBody
    @RequestMapping("file/upload")
    public Map fileUpload (MultipartFile file,HttpServletRequest request) throws IOException {
        HashMap hashMap = new HashMap();
        String realPath = request.getServletContext().getRealPath("/fileSave");
        String originalFilename = file.getOriginalFilename();
        File theFile = new File(realPath + "/" + originalFilename);
        file.transferTo(theFile);
        hashMap.put("error",0);
        hashMap.put("url","/fileSave"+"/"+originalFilename);
        return hashMap;
    }

    //{"status":200,"msg":"OK","data":null}
    @ResponseBody
    @RequestMapping("order/insert")
    public Map orderInsert(Corder corder){
        HashMap hashMap = new HashMap();
        boolean b =corderService.addOrder(corder);
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
     * 编辑页面 edit
     */
    @ResponseBody
    @RequestMapping("order/edit_judge")
    public Map orderEditJudge(){

        //权限校验
        return new HashMap();
    }

    @RequestMapping("order/edit")
    public String orderEdit(){
        return "order_edit";
    }

    @ResponseBody
    @RequestMapping("order/update_all")
    public Map orderUpdateAll(Corder corder){
        HashMap hashMap = new HashMap();
        boolean b = corderService.updateOrder(corder);
        if (b){  //订单编号对应不起来
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
    @RequestMapping("order/delete_judge")
    public Map orderDeleteJudge(){

        return new HashMap();
    }

    @ResponseBody
    @RequestMapping("order/delete_batch")
    public Map orderDeleteBatch(String[] ids){
        HashMap hashMap = new HashMap();
        boolean b = false;
        for (String id:
             ids) {
            b =corderService.deleteOrders(id);
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
    // /order/search_order_by_orderId
    // /order/search_order_by_orderCustom
    // /order/search_order_by_orderProduct
    @ResponseBody
    @RequestMapping("/order/{searchId}")
    public Map orderSearcheOrderId(@PathVariable("searchId")String searchId,String page,String rows,String searchValue ){
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (searchId.equals("search_order_by_orderId")){
            Corder orderById = corderService.findOrderById(searchValue);

            arrayList.add(orderById);
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }
        if (searchId.equals("search_order_by_orderCustom")){
            Custom customByName=customService.findCustomByName(searchValue);
            String theCustomID = customByName.getCustomId();
            List<Corder> corderList=corderService.findOrdersByCustomId(theCustomID);
            for (Corder order:
                 corderList) {
                HashMap map = new HashMap();
                String customId = order.getCustomId();
                String productId = order.getProductId();
                Custom custom = customService.findCustomById(customId);
                Product product = productService.findProductById(productId);
                map.put("orderId",order.getOrderId());
                map.put("orderDate",order.getOrderDate());
                map.put("requestDate",order.getRequestDate());
                map.put("note",order.getNote());
                map.put("quantity",order.getQuantity());
                map.put("unitPrice",order.getUnitPrice());
                map.put("unit",order.getUnit());
                map.put("image",order.getImage());
                map.put("file",order.getFile());
                map.put("status",order.getStatus());
                map.put("custom",custom);
                map.put("product",product);
                arrayList.add(map);
            }
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }
        if (searchId.equals("search_order_by_orderProduct")){
            Product theProduct = productService.findProductByName(searchValue);
            String theProductId = theProduct.getProductId();
            List<Corder> corderList=corderService.findOrderByProductId(theProductId);
            for (Corder order:
                 corderList) {
                HashMap map = new HashMap();
                String customId = order.getCustomId();
                String productId = order.getProductId();
                Custom custom = customService.findCustomById(customId);
                Product product = productService.findProductById(productId);
                map.put("orderId",order.getOrderId());
                map.put("orderDate",order.getOrderDate());
                map.put("requestDate",order.getRequestDate());
                map.put("note",order.getNote());
                map.put("quantity",order.getQuantity());
                map.put("unitPrice",order.getUnitPrice());
                map.put("unit",order.getUnit());
                map.put("image",order.getImage());
                map.put("file",order.getFile());
                map.put("status",order.getStatus());
                map.put("custom",custom);
                map.put("product",product);
                arrayList.add(map);
            }

            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);
        }

        return  hashMap;


    }















}
