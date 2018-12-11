package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.customize.CustomResult;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.technology.Processes;
import com.cskaoyan.service.technology.ProcessService;

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
@RequestMapping("/process")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	@RequestMapping("/get/{processId}")
	@ResponseBody
	public Processes getItemById(@PathVariable String processId) throws Exception{
		Processes processes = processService.get(processId);
		return processes;
	}
	
	@RequestMapping("/find")
	public String find(HttpSession session) throws Exception{
        String[] sysPermissionList= {"process:add","process:edit","process:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
		return "process_list";
	}

    //增加
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addB(){
        return null;
    }
	@RequestMapping("/add")
	public String add() throws Exception{
		return "process_add";
	}

    //编辑
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editB(){
        return null;
    }
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "process_edit";
	}
	
	/*@RequestMapping("/get_data")
	@ResponseBody
	public List<Processes> getData() throws Exception{
		List<Processes> list = processService.find();
		return list;
	}*/

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Processes processes) throws Exception{
		EUDataGridResult result = processService.getList(page, rows, processes);
		return result;
	}
	
	@RequestMapping(value="/insert", method= RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Processes processes, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(processService.get(processes.getProcessId()) != null){
			result = new CustomResult(0, "该工序编号已经存在，请更换工序编号！", null);
		}else{
			result = processService.insert(processes);
		}
		return result;
	}

	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Processes processes, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return processService.updateAll(processes);
	}

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteB(){
        return null;
    }
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = processService.deleteBatch(ids);
		return result;
	}
	
	//根据工序id查找
	@RequestMapping("/search_process_by_processId")
	@ResponseBody
	public EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = processService.searchProcessByProcessId(page, rows, searchValue);
		return result;
	}
	
	//根据工序计划id查找
	@RequestMapping("/search_process_by_technologyPlanId")
	@ResponseBody
	public EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = processService.searchProcessByTechnologyPlanId(page, rows, searchValue);
		return result;
	}
}
