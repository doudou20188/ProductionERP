package com.cskaoyan.mapper;

import com.cskaoyan.domain.technology;

public interface technologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(technology record);

    int insertSelective(technology record);

    technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(technology record);

    int updateByPrimaryKey(technology record);
}