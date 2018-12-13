package com.cskaoyan.controller.materialcontroller;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Consume;
import com.cskaoyan.domain.Material.Vo.MaterialConsumeVO;
import com.cskaoyan.service.material.Impl.M_ConsumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping(value = "/materialConsume")
public class MaterialConsumeController {
    @Autowired
    M_ConsumeServiceImpl m_consumeService;

    @RequestMapping(value = "/add_judge")
    @ResponseBody
    public String  add_judge(){
        return null;
    }
    @RequestMapping(value = "/add")

    public String  add(){
        return "materialConsume_add";
    }


    @RequestMapping(value = "/find")
    public String findMaterial(HttpSession session) {
        ArrayList<String> list = new ArrayList<>();//为打开编辑。删除等按键。添加此list
        list.add("materialConsume:add");
        list.add("materialConsume:edit");
        list.add("materialConsume:delete");
        session.setAttribute("sysPermissionList", list);
        return "materialConsume_list";

    }
    @RequestMapping(value = "/list")
    @ResponseBody
    public Map list(Integer page, Integer rows, MaterialConsumeVO materialConsume){
        //public PageInfo<Material> findmaterialBypage(Integer page, Integer rows) {
        Map findlist = m_consumeService.findlist(page, rows,materialConsume);
        //PageInfo<Material> findmaterial = MaterialService.findmaterial(page, rows);
         return findlist;
     }
     @RequestMapping(value="/insert",method=RequestMethod.POST)
     @ResponseBody
     public CustomResult insert(M_Consume m_consume){
         CustomResult customResult = m_consumeService.insert(m_consume);
         return customResult;

     }
     @RequestMapping(value = "/delete_judge")
     @ResponseBody
    public String delete_judge(){
        return null;
     }
     @RequestMapping(value = "/delete_batch")
     @ResponseBody
    public CustomResult delete_batch(String [] ids){
         CustomResult customResult = m_consumeService.delete_batch(ids);
         return customResult;
     }
     @RequestMapping(value = "/edit_judge")
     @ResponseBody
     public String edit_judge(){
         return null;
     }
    @RequestMapping(value = "/edit")

    public String edit(){
        return "materialConsume_edit";
    }
    @RequestMapping(value = "/update_all")
    @ResponseBody
    public CustomResult update_all(M_Consume m_consume){
        CustomResult update = m_consumeService.update(m_consume);
        return update;

    }

    //根据客户id查找
    @RequestMapping("/search_materialConsume_by_consumeId")
    @ResponseBody
    public Map searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue)
            throws Exception{
        Map map = m_consumeService.searchMaterialConsumeByConsumeId(page, rows, searchValue);
        return map;
    }

    //根据物料id查找
    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public Map searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue)
            throws Exception{
        Map map = m_consumeService.searchMaterialConsumeByMaterialId(page, rows, searchValue);
        return map;
    }

    //根据作业id查找
    @RequestMapping("/search_materialConsume_by_workId")
    @ResponseBody
    public Map searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue)
            throws Exception{
        Map map = m_consumeService.searchMaterialConsumeByWorkId(page, rows, searchValue);
        return map;
    }
    }
