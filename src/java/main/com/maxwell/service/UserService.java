package com.maxwell.service;

import com.maxwell.entity.User;

/**
 * Created by Fhcard on 2018/6/11.
 */
public interface UserService {

    User findUserByName(String name);
}
