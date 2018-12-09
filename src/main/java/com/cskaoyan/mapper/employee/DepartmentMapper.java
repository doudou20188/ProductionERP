package com.cskaoyan.mapper.employee;


import com.cskaoyan.domain.employee.Department;

import java.util.List;

public interface DepartmentMapper {

    List<Department> selectAllDepartments();

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int deleteBatch(String[] ids);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * 搜索功能
     */
    List<Department> searchDepartmentByDepartmentId(String departmentId);

    List<Department> searchDepartmentByDepartmentName(String departmentName);
}