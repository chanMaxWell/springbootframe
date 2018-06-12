package com.maxwell.service;

import com.maxwell.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Repository
public interface RoleService {

    List<Role> findRoleByUserId(Long userId);
}
