package com.maxwell.service.impl;

import com.maxwell.entity.Role;
import com.maxwell.repository.RoleRepository;
import com.maxwell.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findRoleByUserId(Long userId) {
        return roleRepository.findRoleByUserId(userId);
    }
}
