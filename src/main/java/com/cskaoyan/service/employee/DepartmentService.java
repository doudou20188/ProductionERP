package com.cskaoyan.service.employee;

import com.cskaoyan.domain.employee.Department;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;

import java.util.List;

public interface DepartmentService {

    List<Department> selectAllDepartments();

    Department getDepartmentById(String id);

    EUDataGridResult getDepartmentList(int page, int rows);

    CustomResult insert(Department department);

    CustomResult updateAll(Department department);

    CustomResult deleteBatch(String[] ids);

    //搜索功能
    EUDataGridResult searchDepartmentByDepartmentId(int page, int rows, String departmentId);

    EUDataGridResult searchDepartmentByDepartmentName(int page, int rows, String departmentName);

}
