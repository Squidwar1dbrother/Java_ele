package com.ele.dao;

import com.ele.pojo.Admin;

import java.sql.SQLException;

/**
 * 管理员的Dao接口
 */
public interface AdminDao {
    /**
     * 登录功能
     *
     * @param adminName 管理员姓名
     * @param password  管理员密码
     */
    public Admin AdminLogin(String adminName, String password) throws SQLException;

    /**
     *  管理员修改个人密码
     * @param admin_id 管理员编号
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    public Boolean changePassword(Integer admin_id, String newPassword) throws SQLException;
}
