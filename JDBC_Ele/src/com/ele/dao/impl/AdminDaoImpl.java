package com.ele.dao.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.dao.AdminDao;
import com.ele.pojo.Admin;
import com.ele.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员Dao接口的实现类
 */
public class AdminDaoImpl implements AdminDao {

    /**
     * 登录功能
     *
     * @param adminName 管理员姓名
     * @param password  管理员密码
     */
    @Override
    public Admin AdminLogin(String adminName, String password) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        List<Admin> admins = Db.use(ds).query("select * from admin where admin_name = ? and password = ?"
                , Admin.class, adminName, password);
        if (admins.isEmpty()) {
            return null;
        } else {
            return admins.get(0);
        }
    }

    /**
     * 管理员修改个人密码
     *
     * @param admin_id    管理员编号
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    @Override
    public Boolean changePassword(Integer admin_id, String newPassword) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();

        int i = Db.use(ds).update(
                Entity.create().set("password", newPassword)
                , Entity.create("admin").set("admin_id", admin_id)
        );
        return i > 0;
    }
}
