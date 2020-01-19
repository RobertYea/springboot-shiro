package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Ye
 * @description 角色权限Dao
 * @email robertyea@163.com
 * @date 2019/12/31  14:59
 */

@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

}
