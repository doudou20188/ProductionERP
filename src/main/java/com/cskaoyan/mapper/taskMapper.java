package com.cskaoyan.mapper;

import com.cskaoyan.domain.task;

public interface taskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(task record);

    int insertSelective(task record);

    task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(task record);

    int updateByPrimaryKey(task record);
}