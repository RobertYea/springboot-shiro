package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysUserRoleDao;
import com.example.springbootshiro.pojo.SysUserRole;
import com.example.springbootshiro.service.SysUserRoleService;
import org.springframework.stereotype.Service;


/**
 * @author Ye
 * @description  用户角色业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31 0031 15:41
 */

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

}
