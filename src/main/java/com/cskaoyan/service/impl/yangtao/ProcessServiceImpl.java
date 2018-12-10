package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Process;
import com.cskaoyan.mapper.yangtao.ProcessMapper;
import com.cskaoyan.service.yangtao.ProcessService;
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
