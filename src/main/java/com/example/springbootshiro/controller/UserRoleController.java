package com.example.springbootshiro.controller;

import com.example.springbootshiro.service.SysMenuService;
import com.example.springbootshiro.service.SysRoleMenuService;
import com.example.springbootshiro.service.SysRoleService;
import com.example.springbootshiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Ye
 * @description 角色拦截测试类
 * @email robertyea@163.com
 * @date 2020/1/15 0015 14:47
 */

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 管理员角色测试接口
     *
     * @return
     */
    public Map<String, Object> getAdminInfo() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("mgs", "只有管理员角色才能访问此接口");
        return map;
    }

}
