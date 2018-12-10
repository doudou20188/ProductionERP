package com.cskaoyan.mapper;

import com.cskaoyan.domain.manufacture;

public interface manufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(manufacture record);

    int insertSelective(manufacture record);

    manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(manufacture record);

    int updateByPrimaryKey(manufacture record);
}