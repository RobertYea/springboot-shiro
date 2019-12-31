package com.example.springbootshiro.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * @author Ye
 * @description
 * @email robertyea@163.com
 * @date 2019/12/31 0031 14:46
 */

@Data
@TableName("sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色Id
     */
    private long roleId;


    /**
     * 角色名称
     */
    private String roleName;

}
