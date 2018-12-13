package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.customize.CustomResult;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.technology.Processes;
import com.cskaoyan.domain.technology.ProcessesExample;
import com.cskaoyan.mapper.technology.ProcessesMapper;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import com.cskaoyan.service.technology.ProcessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
    TechnologyPlanMapper technologyPlanMapper;
	
	@Autowired
    ProcessesMapper processMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Processes processes) throws Exception{
		//查询商品列表
		ProcessesExample example = new ProcessesExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Processes> list = processMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Processes> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Processes get(String string) throws Exception{
		return processMapper.selectByPrimaryKey(string);
	}
	
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = processMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Processes processes) throws Exception{
		int i = processMapper.insert(processes);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工序信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Processes processes) throws Exception{
		int i = processMapper.updateByPrimaryKey(processes);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序信息失败");
		}
	}

	@Override
	public List<Processes> find() throws Exception{
		ProcessesExample example = new ProcessesExample();
		return processMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchProcessByProcessId(Integer page,
                                                     Integer rows, String processId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Processes> list = processMapper.searchProcessByProcessId(processId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Processes> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchProcessByTechnologyPlanId(Integer page,
                                                            Integer rows, String technologyPlanId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Processes> list = processMapper.searchProcessByTechnologyPlanId(technologyPlanId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Processes> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Processes findProcessById(String processId) {
		return null;
	}

	@Override
	public List<Processes> findAllProcess() {
		return null;
	}
}
