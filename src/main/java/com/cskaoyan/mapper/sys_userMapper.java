package com.cskaoyan.mapper;

import com.cskaoyan.domain.sys_user;

public interface sys_userMapper {
    int deleteByPrimaryKey(String id);

    int insert(sys_user record);

    int insertSelective(sys_user record);

    sys_user selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sys_user record);

    int updateByPrimaryKey(sys_user record);
}