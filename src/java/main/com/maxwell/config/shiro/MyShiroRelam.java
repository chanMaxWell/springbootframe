package com.maxwell.config.shiro;

import com.maxwell.entity.Permission;
import com.maxwell.entity.Role;
import com.maxwell.entity.User;
import com.maxwell.service.PermissionService;
import com.maxwell.service.RoleService;
import com.maxwell.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Fhcard on 2018/6/11.
 */
public class MyShiroRelam extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Autowired
    private UserService userService;

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
        * 缓存过期之后会再次执行。
        */
        logger.info("用户权限配置---------------------------");
        //访问@RequirePermission注解的url时触发
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        //获得用户的角色，及权限进行绑定
        for(Role role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRolename());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }


    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("验证用户登录信息---------------");
        String username = (String)token.getPrincipal();
        logger.info("登录用户名： "+username);
        //从数据库查询出User信息及用户关联的角色，权限信息，以备权限分配时使用
        User user = userService.findUserByName(username);
        if(null == user){
            throw new AccountException("帐号或密码不正确！");
        }else if(user.getStatus() == 1){//锁定
           throw new LockedAccountException("用户被锁定，请联系管理员");
        }else{
            //加密方式;
            //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
                    getName()  //realm name
            );
            return authenticationInfo;
        }
    }
}
