package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.pojo.SysUser;
import org.springframework.stereotype.Repository;


/**
 * @author Ye
 * @description 用户Dao
 * @email robertyea@163.com
 * @date 2019/12/31 0031 15:01
 */

@Repository
public interface SysUesrDao extends BaseMapper<SysUser> {

}
