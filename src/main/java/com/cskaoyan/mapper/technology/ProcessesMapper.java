package com.cskaoyan.mapper.technology;

import com.cskaoyan.domain.technology.Processes;
import com.cskaoyan.domain.technology.ProcessesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessesMapper {

    //扩展的mapper接口方法

    //删除信息（可以多条也可以一条）
    int deleteBatch(String[] ids);

    //通过ProcessId查找相关信息
    List<Processes> searchProcessByProcessId(String processId);

    //通过ProcessPlanId查找相关信息
    List<Processes> searchProcessByTechnologyPlanId(String technologyPlanId);

    //逆向工程生成的mapper接口
    //生成动态查询总条数语句（用于分页的总条数查询）
    int countByExample(ProcessesExample example);

    //生成动态删除语句
    int deleteByExample(ProcessesExample example);

    //按照主键删除对象
    int deleteByPrimaryKey(String processId);

    //插入语句
    int insert(Processes record);

    int insertSelective(Processes record);

    //生成动态查询语句
    List<Processes> selectByExample(ProcessesExample example);

    //按照主键查询对象，相当于getById
    Processes selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Processes record, @Param("example") ProcessesExample example);

    //生成动态修改语句（只修改对象中不为空的属性）
    int updateByExample(@Param("record") Processes record, @Param("example") ProcessesExample example);

    int updateByPrimaryKeySelective(Processes record);

    //按照主键修改对象
    int updateByPrimaryKey(Processes record);

    List<Processes> findAllProcessFromDB();
}