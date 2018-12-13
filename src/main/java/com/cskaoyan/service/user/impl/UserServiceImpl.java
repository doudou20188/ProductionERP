package com.cskaoyan.service.user.impl;

import com.cskaoyan.domain.user.User;
import com.cskaoyan.mapper.user.UserDao;
import com.cskaoyan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User selectUserByLoginName(String loginName) {
        return userDao.selectUserByLoginName(loginName);
    }

    @Override
    public String getRoleByUsername(String username) {
        return userDao.getRoleByUsername(username);
    }

    @Override
    public List<String> queryPermissionByUserName(String username) {

        List<String> permissionList = new ArrayList<>();
        String permissionId = userDao.queryPermissionIdByUsername(username);


        String[] ids = permissionId.split(",");

        for (String id:ids){
            String permission = userDao.queryPermissionByPermissionId(id);
            permissionList.add(permission);
        }

        return permissionList;
    }
}
