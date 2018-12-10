package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Process;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
public interface ProcessService {
    Process findProcessById(String processId);

    List<Process> findAllProcess();
}
