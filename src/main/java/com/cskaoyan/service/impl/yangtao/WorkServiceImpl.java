package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Work;
import com.cskaoyan.mapper.yangtao.WorkMapper;
import com.cskaoyan.service.yangtao.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/9 0009
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    @Override
    public List<Work> findAllWorks() {
        List<Work> workList=workMapper.findAllWorksFromDB();
        return workList;
    }

    @Override
    public boolean addWork(Work work) {
        boolean b = false;
        int i = workMapper.insertSelective(work);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean updateWork(Work work) {
        boolean b =false;
        int i = workMapper.updateByPrimaryKeySelective(work);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean deleteWorkById(String id) {
        boolean b =false;
        int i = workMapper.deleteByPrimaryKey(id);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public Work findWorkByWorkId(String searchValue) {
        Work work = workMapper.selectByPrimaryKey(searchValue);
        return work;
    }

    @Override
    public List<Work> findWorklistByProductId(String theProductId) {
        List<Work> workList=workMapper.findWorklistByProductIdFromDB(theProductId);


        return workList;
    }

    @Override
    public List<Work> findWorklistByDeviceId(String theDeviceId) {
        List<Work> workList=workMapper.findWorklistByDeviceIdFromDB(theDeviceId);

        return workList;
    }

    @Override
    public List<Work> findWorkListByProcessId(String searchValue) {
        List<Work> workList=workMapper.findWorkListByProcessIdFromDB(searchValue);

        return workList;
    }
}
