package com.maxwell.service.impl;

import com.maxwell.entity.Permission;
import com.maxwell.repository.PermissionRepository;
import com.maxwell.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> findPermissionByRoleId(Long roleId) {
        return permissionRepository.findPermissionByRoleId(roleId);
    }
}
