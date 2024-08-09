package com.ele.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    private static final DruidDataSource ds;
    static {
        // 初始化连接池
        ds = new DruidDataSource();
        ds.setPassword("root");
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql:///jdbc_ele");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
