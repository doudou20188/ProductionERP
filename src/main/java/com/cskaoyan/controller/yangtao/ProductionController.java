package com.cskaoyan.controller.yangtao;

import com.cskaoyan.domain.yangtao.Product;
import com.cskaoyan.service.yangtao.ProductService;
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
 * 产品管理控制器
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Controller
public class ProductionController {
    @Autowired
    ProductService productService;


    /**
     * 查找 select
     */
    @RequestMapping("product/find")
    public String productFind(HttpSession session){
        ArrayList sysPermissionList = new ArrayList();
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "product_list";
    }
    @ResponseBody
    @RequestMapping("product/list")
    public Map productList(String page, String rows){
        HashMap hashMap = new HashMap();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> allProducts = productService.findAllProducts();
        hashMap.put("total",allProducts.size());
        hashMap.put("rows",allProducts);
        return hashMap;


    }

    /**
     * 增加操作 add
     */
    @ResponseBody
    @RequestMapping("product/add_judge")
    public Map productAddJudge(){
        //权限管理

        return new HashMap();
    }

    @RequestMapping("product/add")
    public String productAdd(){

        return "product_add";
    }

    //{"status":200,"msg":"OK","data":null}
    @ResponseBody
    @RequestMapping("product/insert")
    public Map productInsert(Product product){
        HashMap hashMap = new HashMap();
        boolean b =productService.addProduct(product);
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
     * 修改操作 edit
     */

    @ResponseBody
    @RequestMapping("product/edit_judge")
    public Map productEditJudge(){
        //权限管理

        return new HashMap();
    }

    @RequestMapping("product/edit")
    public String productEdit(){

        return "product_edit";
    }
    @ResponseBody
    @RequestMapping("product/update_all")
    public Map productUpdateAll(Product product){
        HashMap hashMap = new HashMap();
        boolean b =productService.updateProduct(product);
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
     * 删除操作delete
     */
    @ResponseBody
    @RequestMapping("product/delete_judge")
    public Map productDeleteJudge(){
        //权限管理

        return new HashMap();
    }

    @ResponseBody
    @RequestMapping("product/delete_batch")
    public Map productDeleteBatch(String[] ids){
        HashMap hashMap = new HashMap();
        boolean b =false;
        for (String id:
             ids) {
            b=productService.deleteProducts(id);
            if (b==false){
                break;
            }
        }
        if (b) {
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

    // /product/search_product_by_productId
    // product/search_product_by_productName
    // product/search_product_by_productType

    @ResponseBody
    @RequestMapping("/product/{searchId}")
    public Map productSearch(String page, String rows , String searchValue, @PathVariable("searchId") String searchId){
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (searchId.equals("search_product_by_productId")){
            Product productById = productService.findProductById(searchValue);
            arrayList.add(productById);
            hashMap.put("total",arrayList.size());
            hashMap.put("rows",arrayList);

        }
        if (searchId.equals("search_product_by_productName")){
            //可以是多个结果
            List<Product> productList=productService.findProductListByName(searchValue);
            for (Product product:
                 productList) {
                HashMap map = new HashMap();
                map.put("productId",product.getProductId());
                map.put("productName",product.getProductName());
                map.put("productType",product.getProductType());
                map.put("image",product.getImage());
                map.put("note",product.getNote());
                map.put("status",product.getStatus());
                arrayList.add(map);
                hashMap.put("total",arrayList.size());
                hashMap.put("rows",arrayList);
            }



        }
        if (searchId.equals("search_product_by_productType")){
           List<Product> productList=productService.findProductListByType(searchValue);
            for (Product product:
                    productList) {
                HashMap map = new HashMap();
                map.put("productId",product.getProductId());
                map.put("productName",product.getProductName());
                map.put("productType",product.getProductType());
                map.put("image",product.getImage());
                map.put("note",product.getNote());
                map.put("status",product.getStatus());
                arrayList.add(map);
                hashMap.put("total",arrayList.size());
                hashMap.put("rows",arrayList);
            }
        }

        return hashMap;
    }




}
