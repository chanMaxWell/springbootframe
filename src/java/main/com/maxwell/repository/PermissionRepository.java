package com.maxwell.repository;

import com.maxwell.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Repository
public interface PermissionRepository {

    List<Permission> findPermissionByRoleId(Long roleId);
}
