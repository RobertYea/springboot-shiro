package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysRoleDao;
import com.example.springbootshiro.pojo.SysRole;
import com.example.springbootshiro.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Ye
 * @description 角色业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31  15:35
 */

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    /**
     * 根据用户ID查询其绑定的角色集合
     *
     * @param userId
     *         用户ID
     * @return List<SysRole>  角色集合
     */
    @Override
    public List<SysRole> selectSysRoleByUserId(Long userId) {

        return this.baseMapper.selectSysRoleByUserId(userId);
    }

}
