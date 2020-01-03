package com.example.springbootshiro.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;


/**
 * @author Ye
 * @description SHA-256机密工具类
 * @email robertyea@163.com
 * @date 2020/1/3 0003 11:36
 */

public class SHA256Util {


    /**
     * 构造方法私有化,不允许被外部直接创建
     */
    private SHA256Util() {

    }

    /**
     * 指定加密哈希算法的名称
     */
    public static final String HASH_ALGORITHM_NAME = "SHA-256";

    /**
     * 指定循环次数
     */
    public static final int HASH_ITERATIONS = 15;


    /**
     * 加密方法 采用 SHA256和加盐
     *
     * @param password
     *         密码
     * @param salt
     *         盐值
     * @return
     */
    public static String sha256(String password, String salt) {

        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }

}
