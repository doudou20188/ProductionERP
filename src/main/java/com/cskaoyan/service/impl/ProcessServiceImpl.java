package com.cskaoyan.service.impl;

import com.cskaoyan.domain.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;


    @Override
    public Process findProcessById(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);
        return process;
    }

    @Override
    public List<Process> findAllProcess() {
        List<Process>processList=processMapper.findAllProcessFromDB();

        return processList;
    }
}
