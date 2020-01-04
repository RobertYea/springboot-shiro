package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysUesrDao;
import com.example.springbootshiro.pojo.SysUser;
import com.example.springbootshiro.service.SysUserService;
import org.springframework.stereotype.Service;


/**
 * @author Ye
 * @description 用户业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31  15:40
 */

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUesrDao, SysUser> implements SysUserService {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser selectUserByUsername(String username) {

        return this.baseMapper.selectUserByUsername(username);
    }

}
