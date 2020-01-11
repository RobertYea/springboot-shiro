package com.example.springbootshiro.common.config;

import com.example.springbootshiro.common.shiro.ShiroRealm;
import com.example.springbootshiro.common.shiro.ShiroSessionIdGenerator;
import com.example.springbootshiro.common.shiro.ShiroSessionManager;
import com.example.springbootshiro.common.util.SHA256Util;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


/**
 * @author Ye
 * @description shiro配置类
 * @email robertyea@163.com
 * @date 2020/1/11 0011 11:15
 */

@Configuration
public class ShiroConfig {

    //定义常量
    private final String CACHE_KEY = "shiro:cache:";

    private final String SESSION_KEY = "shiro:session:";

    private final int EXPIRE = 1800;


    /**
     * redis主机
     */
    @Value("${spring.redis.host}")
    private String host;

    /**
     * redis端口
     */
    @Value("${spring.redis.port}")
    private int port;

    /**
     * redis过期时间
     */
    @Value("${spring.redis.timeout}")
    private int timeout;

    /**
     * redis密码
     */
    @Value("${spring.redis.password}")
    private String password;


    /**
     * 开启shiro-aop注解支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * shiro基础配置
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //过滤器配置顺序不能颠倒
        //配置过滤:不会被拦截的路径
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/userLogin/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        //配置shiro默认登录界面地址,前后端分离中登录界面跳转应由前端路由控制,后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/userLogin/unautj");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置redis管理器
     *
     * @return
     */
    @Bean
    public RedisManager redisManager() {

        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * SessionID生成器
     *
     * @return
     */
    @Bean
    public ShiroSessionIdGenerator sessionIdGenerator() {

        return new ShiroSessionIdGenerator();
    }


    /**
     * 配置RedisSessionDAO
     *
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {

        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setExpire(EXPIRE);
        return redisSessionDAO;
    }


    /**
     * 配置session管理器
     *
     * @return
     */
    @Bean
    public SessionManager sessionManager() {

        ShiroSessionManager shiroSessionManager = new ShiroSessionManager();
        shiroSessionManager.setSessionDAO(redisSessionDAO());
        return shiroSessionManager;
    }

    /**
     * 配置Cache管理器
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {

        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        //配置缓存的话要求放在session里面的实体类必须有个id标识
        redisCacheManager.setPrincipalIdFieldName("userId");
        return redisCacheManager;
    }


    /**
     * 凭证匹配器
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {

        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法  这里使用SHA256算法
        shaCredentialsMatcher.setHashAlgorithmName(SHA256Util.HASH_ALGORITHM_NAME);
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        shaCredentialsMatcher.setHashIterations(SHA256Util.HASH_ITERATIONS);
        return shaCredentialsMatcher;
    }


    /**
     * 身份验证器
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {

        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    /**
     * 配置安全管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //自定义session管理器
        securityManager.setSessionManager(sessionManager());
        //自定义Cache实现
        securityManager.setCacheManager(cacheManager());
        //自定义Realm验证
        securityManager.setRealm(shiroRealm());

        return securityManager;
    }


}
