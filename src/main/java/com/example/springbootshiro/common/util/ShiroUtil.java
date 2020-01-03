package com.example.springbootshiro.common.util;

import com.example.springbootshiro.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;


/**
 * @author Ye
 * @description
 * @email robertyea@163.com
 * @date 2020/1/3 0003 16:49
 */


public class ShiroUtil {

    /**
     * 构造方法私有化,不允许外部直接创建
     */
    private ShiroUtil() {

    }

    private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * 获取当前用户的session
     *
     * @return
     */
    public static Session getSession() {

        return SecurityUtils.getSubject().getSession();
    }


    /**
     * 用户登出
     */
    public static void logout() {

    }

    /**
     * 获取当前用户
     *
     * @return
     */
    public static SysUser getUser() {

        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 删除用户缓存
     *
     * @param username
     *         用户名
     * @param isRemoveSession
     *         是否删除session
     */
    public static void deleteCache(String username, boolean isRemoveSession) {

        //从缓存总获取session
        Session session = null;
        Collection<Session> activeSessions = redisSessionDAO.getActiveSessions();
        SysUser user;
        Object attribute = null;
        for (Session activeSession : activeSessions) {
            //对所有session进行遍历,找到username索对应的session
            attribute = activeSession.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (null == attribute) {
                continue;
            }
            user = (SysUser) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (null == user) {
                continue;
            }
            if (Objects.equals(user.getUsername(), username)) {
                session = activeSession;
                break;
            }
        }
        if (null == attribute || null == attribute) {
            return;
        }
        //删除session
        if (isRemoveSession) {
            redisSessionDAO.delete(session);
        }
        //删除cache
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authenticator = securityManager.getAuthenticator();
        ((LogoutAware) authenticator).onLogout((SimplePrincipalCollection) attribute);
    }

}
