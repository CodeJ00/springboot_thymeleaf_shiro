package com.mj.springboot.controller;

import com.mj.springboot.pojo.User;
import com.mj.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Security;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/20 22:36:26
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("loginview")
    public String login(){
        return "login";
    }

    @RequestMapping("registerview")
    public String register(){
        return "register";
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("register")
    public String register(User user){
        try {
            userService.save(user);
            return "redirect:/user/loginview";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/user/registerview";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/user/loginview";
    }
    /**
     * 用来处理身份认证
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            System.out.println("登录成功!");
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误！");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误！");
        }
        return "redirect:/user/loginview";
    }
}
