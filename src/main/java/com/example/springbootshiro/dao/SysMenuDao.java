package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author Ye
 * @description 权限Dao
 * @email robertyea@163.com
 * @date 2019/12/31  14:54
 */

@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

    /**
     * 根据角色ID查询其对应的权限集合
     *
     * @param roleId
     *         角色ID
     * @return List<SysMenu> 权限集合
     */
    List<SysMenu> selectSysMenuByRoleId(long roleId);

}
