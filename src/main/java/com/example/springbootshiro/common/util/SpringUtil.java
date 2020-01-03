package com.example.springbootshiro.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author Ye
 * @description spring上下文工具类
 * @email robertyea@163.com
 * @date 2020/1/3 0003 11:50
 */

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * Spring在bean初始化后会判断该类是不是applicationContextAware的子类
     * 如果是,setApplicationContext()方法,会将容器中ApplicationContext作为参数传入进去
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }

    /**
     * 通过Class返回指定的bean
     *
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> beanClass) {

        return context.getBean(beanClass);
    }

}
