package com.mj.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/22 16:36:03
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Perms {
    private String id;
    private String name;
    private String url;
}
