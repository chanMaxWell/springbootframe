package com.maxwell.entity;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
public class User {

    //用户Id
    private Long id;
    //用户名
    private String name;
    //真实名字
    private String realName;
    //密码
    private String password;
    //盐值
    private String salt;
    //用户状态
    private int status;
    //用户的角色   一对多关系
    private List<Role> roleList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
