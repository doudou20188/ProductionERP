package com.cskaoyan.service;

import com.cskaoyan.domain.Work;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
public interface WorkService {
    List<Work> findAllWorks();

    boolean addWork(Work work);

    boolean updateWork(Work work);

    boolean deleteWorkById(String id);

    Work findWorkByWorkId(String searchValue);

    List<Work> findWorklistByProductId(String theProductId);

    List<Work> findWorklistByDeviceId(String theDeviceId);

    List<Work> findWorkListByProcessId(String searchValue);
}
