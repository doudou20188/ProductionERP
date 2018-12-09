package com.cskaoyan.service.employee.impl;


import com.cskaoyan.domain.employee.Department;
import com.cskaoyan.mapper.employee.DepartmentMapper;
import com.cskaoyan.service.employee.DepartmentService;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDepartments() {
        return departmentMapper.selectAllDepartments();
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public EUDataGridResult getDepartmentList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.selectAllDepartments();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();

        //设置记录总条数
        result.setRows(list);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public CustomResult insert(Department department) {
        int i = departmentMapper.insert(department);
        if (i > 0){
            return CustomResult.ok();
        } else {
            return null;
        }
    }

    @Override
    public CustomResult updateAll(Department department) {
        int i = departmentMapper.updateByPrimaryKey(department);
        if (i>0){
            return CustomResult.ok();
        } else{
            return CustomResult.build(101,"修改员工信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids) {
        int i = departmentMapper.deleteBatch(ids);
        if (i > 0){
            return CustomResult.ok();
        } else {
            return null;
        }
    }

    /**
     * 实现搜索功能
     */
    @Override
    public EUDataGridResult searchDepartmentByDepartmentId(int page, int rows, String departmentId) {
        //注意搜索结果也要进行分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.searchDepartmentByDepartmentId(departmentId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public EUDataGridResult searchDepartmentByDepartmentName(int page, int rows, String departmentName) {
        //注意搜索结果也要进行分页处理
        PageHelper.startPage(page, rows);
        List<Department> list = departmentMapper.searchDepartmentByDepartmentName(departmentName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }
}
