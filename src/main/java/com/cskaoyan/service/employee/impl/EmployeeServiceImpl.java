package com.cskaoyan.service.employee.impl;

import com.cskaoyan.domain.employee.Employee;
import com.cskaoyan.mapper.employee.EmployeeMapper;
import com.cskaoyan.service.employee.EmployeeService;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeById(String empId) {
        return employeeMapper.selectEmployeeById(empId);
    }

    @Override
    public CustomResult insert(Employee employee) {
        int i = employeeMapper.insert(employee);
        if (i > 0){
            return CustomResult.ok();
        } else {
            return null;
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int i = employeeMapper.deleteBatch(ids);
        if (i > 0){
            return CustomResult.ok();
        } else {
            return null;
        }
    }

    @Override
    public CustomResult updateAll(Employee employee) {
        int i = employeeMapper.updateByPrimaryKey(employee);
        if (i>0){
            return CustomResult.ok();
        } else{
            return CustomResult.build(101,"修改员工信息失败");
        }
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }


    @Override
    public EUDataGridResult getEmployeeList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Employee> employeeList = employeeMapper.selectAllEmployees();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        //设置记录总条数
        result.setRows(employeeList);
        //PageInfo是PageHelper中定义的类,List<T>为结果集
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 下三个方法实现员工的搜索功能
     */

    @Override
    public EUDataGridResult searchEmployeeByEmployeeId(int page, int rows, String employeeId) {

        //分页处理
        PageHelper.startPage(page, rows);
        List<Employee> list = employeeMapper.searchEmployeeByEmployeeId(employeeId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public EUDataGridResult searchEmployeeByEmployeeName(int page, int rows, String employeeName) {

        //分页处理
        PageHelper.startPage(page, rows);
        List<Employee> list = employeeMapper.searchEmployeeByEmployeeName(employeeName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public EUDataGridResult searchEmployeeByDepartmentName(int page, int rows, String departmentName) {

        //分页处理
        PageHelper.startPage(page, rows);
        List<Employee> list = employeeMapper.searchEmployeeByDepartmentName(departmentName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }
}
