package com.example.springbootshiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootshiro.pojo.SysUser;


/**
 * @author Ye
 * @description 用户业务接口
 * @email robertyea@163.com
 * @date 2019/12/31  15:26
 */
public interface SysUserService extends IService<SysUser> {

    /**根据用户名查找用户
     * @param username
     * @return
     */
    SysUser selectUserByUsername(String username);

}
