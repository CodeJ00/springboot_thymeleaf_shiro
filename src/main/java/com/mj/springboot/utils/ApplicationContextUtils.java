package com.mj.springboot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 37714
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 14:21:46
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    public static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
