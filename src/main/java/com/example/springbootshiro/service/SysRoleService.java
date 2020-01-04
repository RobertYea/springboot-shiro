package com.example.springbootshiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootshiro.pojo.SysRole;

import java.util.List;


/**
 * @author Ye
 * @description 角色业务接口
 * @email robertyea@163.com
 * @date 2019/12/31  15:23
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户ID查询其绑定的角色集合
     *
     * @param userId
     *         用户ID
     * @return List<SysRole>  角色集合
     */
    List<SysRole> selectSysRoleByUserId(Long userId);

}
