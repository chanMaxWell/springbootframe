package com.maxwell.service;

import com.maxwell.entity.Permission;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
public interface PermissionService {

    List<Permission> findPermissionByRoleId(Long roleId);
}
