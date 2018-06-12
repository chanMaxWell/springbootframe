package com.maxwell.repository;

import com.maxwell.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Fhcard on 2018/6/11.
 */
@Repository
public interface UserRepository {

    boolean addUser(User user);

    User findUserByName(String name);
}
