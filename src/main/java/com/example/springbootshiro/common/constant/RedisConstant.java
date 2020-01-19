package com.example.springbootshiro.common.constant;

/**
 * @author Ye
 * @description Redis常量类
 * @email robertyea@163.com
 * @date 2020/1/15 0015 14:43
 */

public class RedisConstant {

    /**
     * TOKEN前缀
     */
    public final String REDIS_PREFIX_LOGIN = "login_token_%s";

    /**
     * 过期时间2小时
     */
    public final Integer REDIS_EXPIRE_TWO = 7200;

    /**
     * 过期时间15分
     */
    public final Integer REDIS_EXPIRE_EMAIL = 900;

    /**
     * 过期时间5分钟
     */
    public final Integer REDIS_EXPIRE_KAPTCHA = 300;

    /**
     * 暂无过期时间
     */
    public final Integer REDIS_EXPIRE_NULL = -1;

}
