package com.mj.springboot.utils;

import java.util.Random;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 13:12:23
 */
public class SaltUtils {
    public static String getSalt( int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789！@#￥%……&*（）".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(4);
        System.out.println(salt);
    }
}
