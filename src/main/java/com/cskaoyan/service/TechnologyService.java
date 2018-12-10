package com.cskaoyan.service;

import com.cskaoyan.domain.Technology;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
public interface TechnologyService {
    Technology findTechnologyById( String technologyId);

    List<Technology> finAllTechnology();

    List<Technology> findTechnologyByTechnologyName( String searchValue);
}
