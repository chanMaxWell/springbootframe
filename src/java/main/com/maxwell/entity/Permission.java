package com.maxwell.entity;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
public class Permission {
    //权限Id
    private Long id;
    //模块名
    private String modelname;
    //权限名
    private String permission;
    //角色权限关系   多对多
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
