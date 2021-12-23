package com.mj.springboot.service;



import com.mj.springboot.pojo.Perms;
import com.mj.springboot.pojo.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User selectByUsername(String username);

    User selectRolesByUsername(String username);

    List<Perms> selectPermsByRoleId(String id);
}
