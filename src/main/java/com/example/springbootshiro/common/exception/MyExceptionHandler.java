package com.example.springbootshiro.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Ye
 * @description 自定义异常
 * @email robertyea@163.com
 * @date 2020/1/3 0003 11:28
 */

@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理shiro鉴权异常
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(AuthenticationException.class)
    public Map<String, Object> defaultErrorHandler() {


        HashMap<String, Object> map = new HashMap<>();
        map.put("403", "权限不足");
        return map;
    }

}
