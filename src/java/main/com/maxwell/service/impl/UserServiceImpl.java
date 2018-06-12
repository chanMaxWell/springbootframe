package com.maxwell.service.impl;

import com.maxwell.entity.Permission;
import com.maxwell.entity.Role;
import com.maxwell.entity.User;
import com.maxwell.repository.UserRepository;
import com.maxwell.service.PermissionService;
import com.maxwell.service.RoleService;
import com.maxwell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //根据登录名查询用户信息、角色、权限。
    @Override
    public User findUserByName(String name) {
        User user = userRepository.findUserByName(name);
        Long userId = user.getId();
        List<Role>roles = roleService.findRoleByUserId(userId);
        for(Role role:roles){
            List<Permission>permissions = permissionService.findPermissionByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        user.setRoleList(roles);
        return user;
    }
}
