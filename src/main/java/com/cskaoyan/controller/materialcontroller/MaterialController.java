package com.cskaoyan.controller.materialcontroller;


import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Receive;
import com.cskaoyan.domain.Material.Material;
import com.cskaoyan.service.material.M_ReceiveService;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping( {"/material","/Material"})

public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    M_ReceiveService m_receiveService;




    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> getData() throws Exception{
        return materialService.getdata();
    }

    @RequestMapping(value = "/find")
    public String findMaterial(HttpSession session) {
        ArrayList<String> list = new ArrayList<>();//为打开编辑。删除等按键。添加此list
        list.add("Material:add");
        list.add("Material:edit");
        list.add("Material:delete");
        session.setAttribute("sysPermissionList", list);

        return "material_list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map findmaterialBypage(Integer page, Integer rows) {
        //public PageInfo<Material> findmaterialBypage(Integer page, Integer rows) {
        Map findmaterial = materialService.findmaterial(page, rows);
        //PageInfo<Material> findmaterial = MaterialService.findmaterial(page, rows);
        return findmaterial;
    }

    @RequestMapping(value = "/add_judge")
    @ResponseBody
    public String add() {

        return null;
    }

    @RequestMapping(value = "/add")
    public String addmaterial() {
        return "material_add";
    }


    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    @ResponseBody
    public CustomResult insertmaterial(Material material) {

        CustomResult customResult = materialService.insertMaterial(material);
        return customResult;


    }
    @RequestMapping(value = "/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return null;
    }
    @RequestMapping(value = "/delete_batch")
    @ResponseBody
    public CustomResult delete_batch(String[] ids) {
        CustomResult customResult = materialService.delete_batch(ids);
        return customResult;
    }
    @RequestMapping(value = "/edit_judge")
    @ResponseBody
     public String edit_judge() {

        return null;
    }
    //修改
    @RequestMapping(value = "/edit")
    public String edit() {
        return "material_edit";
    }
    @RequestMapping(value = "/update_all")
    @ResponseBody
    public CustomResult update_all(Material material) {
        //System.out.println(Material.toString());
        CustomResult customResult = materialService.update_all(material);
        return customResult;
    }

    @RequestMapping(value = "/search_material_by_materialId")
    @ResponseBody
    public Map SearchMaterialByMaterialId(Integer page, Integer rows,String searchValue) {
        //public PageInfo<Material> findmaterialBypage(Integer page, Integer rows) {
        Map map = materialService.SearchMaterialByMaterialId(page, rows, searchValue);
        //PageInfo<Material> findmaterial = MaterialService.findmaterial(page, rows);
        return map;
    }
    @RequestMapping(value = "/search_material_by_materialType")
    @ResponseBody
    public Map SearchMaterialByMaterialType(Integer page, Integer rows,String searchValue) {
        //public PageInfo<Material> findmaterialBypage(Integer page, Integer rows) {
        Map map = materialService.SearchMaterialByMaterialType(page, rows, searchValue);

        //PageInfo<Material> findmaterial = MaterialService.findmaterial(page, rows);
        return map;
    }



}
