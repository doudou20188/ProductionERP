package com.cskaoyan.service.employee;

import com.cskaoyan.domain.employee.Employee;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    EUDataGridResult getEmployeeList(int page, int rows);

    Employee getEmployeeById(String empId);

    CustomResult insert(Employee employee);

    CustomResult updateAll(Employee employee);

    CustomResult deleteBatch(String[] ids);

    EUDataGridResult searchEmployeeByEmployeeId(int page, int rows, String employeeId);

    EUDataGridResult searchEmployeeByEmployeeName(int page, int rows, String employeeName);

    EUDataGridResult searchEmployeeByDepartmentName(int page, int rows, String departmentName);



}
