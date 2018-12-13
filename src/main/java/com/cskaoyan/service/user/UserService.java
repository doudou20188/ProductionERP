package com.cskaoyan.service.user;

import com.cskaoyan.domain.user.User;

import java.util.List;

public interface UserService {

    User selectUserByLoginName(String loginName);

    List<String> queryPermissionByUserName(String username);

    String getRoleByUsername(String username);
}
