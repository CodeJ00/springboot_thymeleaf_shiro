package com.mj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/23 16:27:30
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String hello(){
        System.out.println("hello springboot");
        return "index";
    }
}
