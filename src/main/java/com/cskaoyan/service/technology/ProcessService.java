package com.cskaoyan.service.technology;

import com.cskaoyan.domain.customize.CustomResult;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.technology.Processes;

import java.util.List;

public interface ProcessService {
	
	List<Processes> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, Processes processes) throws Exception;

	Processes get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(Processes processes) throws Exception;
	
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Processes processes) throws Exception;

    //通过ProcessId查找信息
	EUDataGridResult searchProcessByProcessId(Integer page, Integer rows,
                                              String processId) throws Exception;
	//通过ProcessPlanId查找信息
	EUDataGridResult searchProcessByTechnologyPlanId(Integer page,
                                                     Integer rows, String technologyPlanId) throws Exception;
	Processes findProcessById(String processId);

	List<Processes> findAllProcess();


}
