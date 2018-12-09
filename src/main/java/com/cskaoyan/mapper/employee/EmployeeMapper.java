package com.cskaoyan.mapper.employee;



import com.cskaoyan.domain.employee.Employee;

import java.util.List;

public interface EmployeeMapper {

    //选取所有的员工
    //@Select("select * from employee")
    List<Employee> selectAllEmployees();

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int deleteBatch(String[] ids);

    int insertSelective(Employee record);

    Employee selectEmployeeById(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    //搜索功能的接口
    List<Employee> searchEmployeeByEmployeeId(String employeeId);

    List<Employee> searchEmployeeByEmployeeName(String employeeName);

    List<Employee> searchEmployeeByDepartmentName(String departmentName);

}