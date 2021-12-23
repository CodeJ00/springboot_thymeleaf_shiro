package com.mj.springboot.service;

import com.mj.springboot.dao.UserDao;
import com.mj.springboot.pojo.User;
import com.mj.springboot.pojo.Perms;
import com.mj.springboot.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 13:04:56
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;



    @Override
    public void save(User user) {
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);
    }

    @Override
    public User selectByUsername(String username) {
        User user = userDao.selectByUsername(username);
        return user;
    }

    @Override
    public User selectRolesByUsername(String username) {
        return userDao.selectRolesByUsername(username);
    }

    @Override
    public List<Perms> selectPermsByRoleId(String id) {
        return userDao.selectPermsByRoleId(id);
    }
}
