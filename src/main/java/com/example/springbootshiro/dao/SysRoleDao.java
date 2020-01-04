package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Ye
 * @description 角色Dao
 * @email robertyea@163.com
 * @date 2019/12/31  14:58
 */

@Repository
public interface SysRoleDao extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询其绑定的角色集合
     *
     * @param userId
     *         用户ID
     * @return List<SysRole>  角色集合
     */
    List<SysRole> selectSysRoleByUserId(Long userId);

}
