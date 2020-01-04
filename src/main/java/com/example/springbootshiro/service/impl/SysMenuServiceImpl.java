package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysMenuDao;
import com.example.springbootshiro.pojo.SysMenu;
import com.example.springbootshiro.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Ye
 * @description 权限业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31  15:28
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    /**
     * 根据角色ID查询其对应的权限集合
     *
     * @param roleId
     *         角色ID
     * @return List<SysMenu> 权限集合
     */
    @Override
    public List<SysMenu> selectSysMenuByRoleId(long roleId) {

        return this.baseMapper.selectSysMenuByRoleId(roleId);
    }

}
