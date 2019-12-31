package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysRoleDao;
import com.example.springbootshiro.pojo.SysRole;
import com.example.springbootshiro.service.SysRoleService;
import org.springframework.stereotype.Service;


/**
 * @author Ye
 * @description 角色业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31 0031 15:35
 */

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

}
