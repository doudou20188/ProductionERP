package com.cskaoyan.controller.materialcontroller;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Receive;
import com.cskaoyan.service.material.M_ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping(value = "/materialReceive")
public class MaterialReceiveController {

    @Autowired
    M_ReceiveService m_receiveService;


    @RequestMapping(value = "/find")
    public String findMaterial(HttpSession session) {
        ArrayList<String> list = new ArrayList<>();
        list.add("materialReceive:add");
        list.add("materialReceive:edit");
        list.add("materialReceive:delete");
        session.setAttribute("sysPermissionList", list);

        return "materialReceive_list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map findm_ReceiveBypage(Integer page, Integer rows) {
        //public PageInfo<Material> findmaterialBypage(Integer page, Integer rows) {
        Map findmaterial = m_receiveService.findm_receiveService(page, rows);
        //PageInfo<Material> findmaterial = MaterialService.findmaterial(page, rows);
        return findmaterial;
    }

    @RequestMapping(value = "add_judge")
    @ResponseBody
    public String add_judge() {
        return null;
    }

    @RequestMapping(value = "add")
    public String add() {
        return "materialReceive_add";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(M_Receive m_receive) {
        CustomResult insert = m_receiveService.insert(m_receive);
        return insert;

    }

    @RequestMapping(value = "/edit_judge")
    @ResponseBody
    public String iedit_judge() {
        return null;
    }

    @RequestMapping(value = "/edit")
    public String edit() {
        return "materialReceive_edit";
    }

    @RequestMapping(value = "/update_all")
    @ResponseBody
    public CustomResult update_all(M_Receive m_receive) {
        CustomResult customResult = m_receiveService.update_all(m_receive);
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

        CustomResult customResult = m_receiveService.delete_batch(ids);
        return customResult;
    }

    @RequestMapping(value = "/search_materialReceive_by_materialId")
    @ResponseBody
    public Map SearchMaterialReceiveByMaterialId(Integer page, Integer rows, String searchValue) {


        Map map = m_receiveService.SearchMaterialReceiveByMaterialId(page, rows, searchValue);
        return map;
    }
    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public Map searchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue){

        Map map = m_receiveService.SearchMaterialReceiveByReceiveId(page, rows, searchValue);

        return map;
    }


}
