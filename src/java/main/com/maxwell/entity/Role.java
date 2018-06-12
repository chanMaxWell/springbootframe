package com.maxwell.entity;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
public class Role {

    //角色Id
    private Long id;
    //角色名称
    private String rolename;
    //角色描述
    private String roledesc;
    //角色权限关系  多对多  一个角色对应多个权限
    private List<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
