package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.ele.dao.AdminDao;
import com.ele.pojo.Admin;
import com.ele.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  管理员Dao的实现类
 */
public class AdminDaoImpl implements AdminDao {

    /**
     *  管理员登录功能
     * @param adminName 管理员账号
     * @param password 管理员密码
     * @return 管理员界面
     */
    @Override
    public Admin adminLogin(String adminName, String password) throws SQLException {
        // 获取工具类里的连接
        Connection connection = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "select * from admin where admin_name = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,adminName);
        ps.setString(2,password);
        // 获取sql语句执行后的结果
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            // 封装结果
            Admin admin = new Admin();
            admin.setAdminId(rs.getInt("admin_id"));
            admin.setAdminName(rs.getString("admin_name"));
            admin.setPassword(rs.getString("password"));
            return admin;
        }
        return null;
    }

    /**
     *  管理员修改自己的密码功能
     * @param adminId 管理员id
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    @Override
    public Boolean changePassword(Integer adminId, String newPassword) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).update(
                Entity.create().set("password", newPassword)
                , Entity.create("admin").set("admin_id", adminId)
        );
        return i == 1;
    }
}
