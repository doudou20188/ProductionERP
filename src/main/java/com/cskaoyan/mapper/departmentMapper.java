package com.cskaoyan.mapper;

import com.cskaoyan.domain.department;

public interface departmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(department record);

    int insertSelective(department record);

    department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(department record);

    int updateByPrimaryKey(department record);
}