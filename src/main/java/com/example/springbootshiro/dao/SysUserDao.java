package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Ye
 * @description 用户Dao
 * @email robertyea@163.com
 * @date 2019/12/31  15:01
 */

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    SysUser selectUserByUsername(String username);

}
