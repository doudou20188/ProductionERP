package com.cskaoyan.service;

import com.cskaoyan.domain.Task;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/6 0006
 */
public interface TaskService {
    List<Task> findAllTasks();

    int findTasksCount();

    int insertIntoTask(Task task);

    boolean updateTask(Task task);

    boolean deleteTaskById(String ids);

    Task findTaskById(String searchValue);

    List<Task> findTaskByTaskWorkId(String searchValue);

    List<Task> findTaskBytaskManufactureSn(String searchValue);
}
