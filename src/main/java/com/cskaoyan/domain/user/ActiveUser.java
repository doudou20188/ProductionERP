package com.cskaoyan.domain.user;


import java.io.Serializable;

/**
 * ActiveUser，用来保存认证信息。它里面可以包含realm从数据库查询用户信息，
 * 以及后续的用户菜单、usercode、username等。
 * 都通过ActiveUser设置在SimpleAuthenticationInfo中。
 */

public class ActiveUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userid; //用户id（主键）
    private String username; //用户名称
    private String userStatus; //用户状态
    private String rolename; //角色名称

    @Override
    public String toString() {
        return "ActiveUser{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
