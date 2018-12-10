package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Technology;

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
