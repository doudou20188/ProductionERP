package com.cskaoyan.shiro;

import com.cskaoyan.domain.user.ActiveUser;
import com.cskaoyan.domain.user.User;
import com.cskaoyan.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Override
    public String getName(){
        return "customRealm";
    }

    @Autowired
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //什么是logger，有什么用处？
        Logger logger = LoggerFactory.getLogger(CustomRealm.class);
        System.out.println("CustomRealm authentication is used..");

        String principal = (String) authenticationToken.getPrincipal();
        System.out.println("principal = " + principal);
        logger.info("principal = " + principal);

        //根据用户名和密码去查询数据库看看是否这个用户
        User user = userService.selectUserByLoginName(principal);
        String username = user.getUsername();
        //查询当前用户的角色
        if (user == null) {
            return null;
        }

        String password_from_db = user.getPassword();
        //查询当前用户的角色
        String role = userService.getRoleByUsername(username);
        //根据用户名获取该用户的权限
        List<String> permissions = userService.queryPermissionByUserName(username);

        /*将用户封装到一个用户信息的vo中*/
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(user.getId() + "");
        activeUser.setUsername(username);
        activeUser.setRolename(role);
        activeUser.setUserStatus("1");
        activeUser.setPermissions(permissions);

        //传进来的第一个参数：1，传给授权器 2，放到session里面方便取数据
        //可以使用ActiveUser保存认证信息，并放置在SimpleAuthenticationInfo中
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password_from_db, getName());
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //注意取出的principle就是User类的对象，可以根据getter取出username
        //再调用service方法根据username找出对应的权限
        ActiveUser primaryPrincipal = (ActiveUser) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //可以再写一个获取该user的role的方法，并将该role加到Info中去
        simpleAuthorizationInfo.addRole(primaryPrincipal.getRolename());


        simpleAuthorizationInfo.addStringPermissions(primaryPrincipal.getPermissions());

        return simpleAuthorizationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


}
