package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Technology;
import com.cskaoyan.mapper.yangtao.TechnologyMapper;
import com.cskaoyan.service.yangtao.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;


    @Override
    public Technology findTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public List<Technology> finAllTechnology() {
        List<Technology> technologyList= technologyMapper.findAllTechnologyFromDB();

        return technologyList;
    }

    @Override
    public  List<Technology>findTechnologyByTechnologyName(String searchValue) {
        List<Technology> technologyList=technologyMapper.findTechnologyByTechnologyNameFromDB(searchValue);
        return technologyList;
    }
}