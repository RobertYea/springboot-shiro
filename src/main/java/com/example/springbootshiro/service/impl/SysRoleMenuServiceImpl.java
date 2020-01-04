package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysRoleMenuDao;
import com.example.springbootshiro.pojo.SysRoleMenu;
import com.example.springbootshiro.service.SysRoleMenuService;
import org.springframework.stereotype.Service;


/**
 * @author Ye
 * @description 角色权限业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31  15:38
 */

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

}
