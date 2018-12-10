package com.cskaoyan.service.impl;

import com.cskaoyan.domain.Task;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/6 0006
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> findAllTasks() {
        List<Task> allTasksFromDB = taskMapper.findAllTasksFromDB();
        return allTasksFromDB;
    }

    @Override
    public int findTasksCount() {
        int count=taskMapper.findTasksCountFromDB();

        return count;
    }

    @Override
    public int insertIntoTask(Task task) {
        int insert = taskMapper.insert(task);

        return insert;
    }

    @Override
    public boolean updateTask(Task task) {
        boolean b =false;
        int i = taskMapper.updateByPrimaryKeySelective(task);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean deleteTaskById(String ids) {
        boolean b =false;

        int i = taskMapper.deleteByPrimaryKey(ids);
        if (i!=0){
            b=true;
        }
        return b;
    }

    @Override
    public Task findTaskById(String searchValue) {

        Task task = taskMapper.selectByPrimaryKey(searchValue);
        return task;
    }

    @Override
    public List<Task> findTaskByTaskWorkId(String searchValue) {
        List<Task> taskList=taskMapper.findTaskByTaskWorkIdFromDB(searchValue);
        return taskList;
    }

    @Override
    public List<Task> findTaskBytaskManufactureSn(String searchValue) {
        List<Task> taskList=taskMapper.findTaskBytaskManufactureSnFromDB(searchValue);
        return taskList;
    }
}
