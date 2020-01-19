package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Ye
 * @description 用户角色Dao
 * @email robertyea@163.com
 * @date 2019/12/31  15:00
 */

@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}
