package com.cskaoyan.mapper;

import com.cskaoyan.domain.employee;

public interface employeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(employee record);

    int insertSelective(employee record);

    employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(employee record);

    int updateByPrimaryKey(employee record);
}