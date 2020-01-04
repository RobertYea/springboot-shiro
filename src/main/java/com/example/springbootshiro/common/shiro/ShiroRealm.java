package com.example.springbootshiro.common.shiro;

import com.example.springbootshiro.common.util.ShiroUtil;
import com.example.springbootshiro.pojo.SysMenu;
import com.example.springbootshiro.pojo.SysRole;
import com.example.springbootshiro.pojo.SysUser;
import com.example.springbootshiro.service.SysMenuService;
import com.example.springbootshiro.service.SysRoleService;
import com.example.springbootshiro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;


/**
 * @author Ye
 * @description shiro鉴权
 * @email robertyea@163.com
 * @date 2020/1/4  16:51
 */

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 授权操作 用户进行权限验证的时候Shiro会查找缓存,如果查不到数据,则会将权限加入缓存中
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取用户ID
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        Long userId = sysUser.getUserId();
        //进行授权处理
        HashSet<String> roleSet = new HashSet<>();
        HashSet<String> permsSet = new HashSet<>();
        //查询角色和权限
        List<SysRole> sysRoleList = sysRoleService.selectSysRoleByUserId(userId);
        for (SysRole sysRole : sysRoleList) {
            roleSet.add(sysRole.getRoleName());
            List<SysMenu> sysMenuList = sysMenuService.selectSysMenuByRoleId(sysRole.getRoleId());
            for (SysMenu sysMenu : sysMenuList) {
                permsSet.add(sysMenu.getPerms());
            }
        }
        //将查询到的角色权限存入simpleAuthorizationInfo中
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.setStringPermissions(permsSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        //根据username从数据库中查找User对象,如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUser user = sysUserService.selectUserByUsername(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号状态是否正常
        if (user.getState() == null || user.getState().equals("PROHIBIT")) {
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user,                                           //用户名
                user.getPassword(),                             //密码
                ByteSource.Util.bytes(user.getSalt()),          //盐值
                getName()                                       //Realm名字
        );
        //验证成功 清除cache和session
        ShiroUtil.deleteCache(username, true);
        return simpleAuthenticationInfo;
    }

}
