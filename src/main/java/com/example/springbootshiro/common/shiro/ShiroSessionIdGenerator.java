package com.example.springbootshiro.common.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;


/**
 * @author Ye
 * @description 自定义SessionId生成器
 * @email robertyea@163.com
 * @date 2020/1/3 0003 17:26
 */


public class ShiroSessionIdGenerator implements SessionIdGenerator {

    /**
     * 生成sessionId
     *
     * @param session 当前session
     * @return
     */
    @Override
    public Serializable generateId(Session session) {

        Serializable id = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", id);
    }

}
