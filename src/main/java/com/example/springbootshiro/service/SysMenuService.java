package com.example.springbootshiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootshiro.pojo.SysMenu;

import java.util.List;


/**
 * @author Ye
 * @description 权限业务接口
 * @email robertyea@163.com
 * @date 2019/12/31  15:21
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据角色ID查询其对应的权限集合
     *
     * @param roleId
     *         角色ID
     * @return List<SysMenu> 权限集合
     */
    List<SysMenu> selectSysMenuByRoleId(long roleId);

}
