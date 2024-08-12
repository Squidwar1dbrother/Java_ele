package com.ele.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *  JDBC连接池的工具类
 */
public class JDBCUtils {
    private static final DruidDataSource DS;
    static {
        // 初始化连接池
        DS = new DruidDataSource();
        DS.setDriverClassName("com.mysql.jdbc.Driver");
        DS.setUrl("jdbc:mysql:///jdbc_ele");
        DS.setUsername("root");
        DS.setPassword("root");
    }
    public static DruidDataSource getDruidSource(){
        return DS;
    }
}
