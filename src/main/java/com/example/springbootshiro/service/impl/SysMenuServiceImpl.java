package com.example.springbootshiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootshiro.dao.SysMenuDao;
import com.example.springbootshiro.pojo.SysMenu;
import com.example.springbootshiro.service.SysMenuService;
import org.springframework.stereotype.Service;


/**
 * @author Ye
 * @description 权限业务实现类
 * @email robertyea@163.com
 * @date 2019/12/31 0031 15:28
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}
