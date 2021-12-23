package com.mj.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 12:50:23
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private  String password;
    private String salt;

    private List<Role> roles;
}
