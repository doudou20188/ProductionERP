package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.customize.CustomResult;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.technology.Technology;
import com.cskaoyan.service.technology.TechnologyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

	@Autowired
	private TechnologyService technologyService;
	
	@RequestMapping("/get/{technologyId}")
	@ResponseBody
	public Technology getItemById(@PathVariable String technologyId) throws Exception{
		Technology technology = technologyService.get(technologyId);
		return technology;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "technology_list";
	}

	//增加
	@RequestMapping("/add_judge")
	@ResponseBody
	public String addB(){
		return null;
	}
	@RequestMapping("/add")
	@RequiresPermissions("technology:add")
	public String add() throws Exception{
		/*String[] sysPermissionList= {"com.cskaoyan.mapper.technology:add","com.cskaoyan.mapper.technology:edit","com.cskaoyan.mapper.technology:delete"};
		session.setAttribute("sysPermissionList",sysPermissionList);*/
		return "technology_add";
	}

	//编辑
	@RequestMapping("/edit_judge")
	@ResponseBody
	public String editB(){
		return null;
	}
	@RequestMapping("/edit")
	@RequiresPermissions("technology:edit")
	public String edit() throws Exception{
		/*String[] sysPermissionList= {"com.cskaoyan.mapper.technology:add","com.cskaoyan.mapper.technology:edit","com.cskaoyan.mapper.technology:delete"};
		session.setAttribute("sysPermissionList",sysPermissionList);*/
		return "technology_edit";
	}
	
	/*@RequestMapping("/get_data")
	@ResponseBody
	public List<Technology> getData() throws Exception{
		 List<Technology> list = technologyService.find();
		return list;
	}*/
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Technology technology) throws Exception{
		EUDataGridResult result = technologyService.getList(page, rows, technology);
		System.out.println("result = " + result);
		return result;
	}


	@RequestMapping(value="/insert", method= RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Technology technology, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(technologyService.get(technology.getTechnologyId()) != null){
			result = new CustomResult(0, "该工艺编号已经存在，请更换工艺编号！", null);
		}else{
			result = technologyService.insert(technology);
		}
		return result;
	}

	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Technology technology, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return technologyService.updateAll(technology);
	}

	@RequestMapping("/delete_judge")
	@ResponseBody
	public String deleteB(){
		return null;
	}
	@RequestMapping(value="/delete_batch")
	@RequiresPermissions("technology:delete")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyService.deleteBatch(ids);
		return result;
	}
	
	//根据工艺id查找
	@RequestMapping("/search_technology_by_technologyId")
	@ResponseBody
	public EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = technologyService.searchTechnologyByTechnologyId(page, rows, searchValue);
		return result;
	}
	
	//根据工艺名称查找
	@RequestMapping("/search_technology_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyByTechnologyName(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = technologyService.searchTechnologyByTechnologyName(page, rows, searchValue);
		return result;
	}
	
}
