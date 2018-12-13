package com.cskaoyan.mapper.user;

import com.cskaoyan.domain.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    //注意使用注解时先实验sql语句是否正确

    @Select("SELECT * FROM `sys_user` where username = #{username}")
    User selectUserByLoginName(String loginName);

    @Select("SELECT sr.role_name FROM `sys_user` su\n" +
            "LEFT JOIN sys_user_role sur ON su.id = sur.sys_user_id\n" +
            "LEFT JOIN sys_role sr ON sur.sys_role_id = sr.role_id\n" +
            "where su.username=#{username}")
    String getRoleByUsername(String username);

    @Select("SELECT srp.sys_permission_id FROM `sys_user` su\n" +
            "LEFT JOIN sys_user_role sur ON su.id = sur.sys_user_id\n" +
            "LEFT JOIN sys_role_permission srp ON sur.sys_role_id = srp.sys_role_id\n" +
            "where su.username=#{username}")
    String queryPermissionIdByUsername(String username);

    @Select("SELECT percode FROM `sys_permission` WHERE type='permission' and id = #{id}")
    String queryPermissionByPermissionId(@Param("id") String id);

}
