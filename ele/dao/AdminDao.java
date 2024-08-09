package com.ele.dao;

import com.ele.pojo.Admin;

import java.sql.SQLException;

/**
 *  管理员Dao的接口
 */
public interface AdminDao {
    /**
     *  管理员登录功能
     * @param adminName 管理员账号
     * @param password 管理员密码
     * @return 管理员界面
     */
    public Admin adminLogin(String adminName,String password) throws SQLException;

    /**
     *  管理员修改自己的密码功能
     * @param adminId 管理员id
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    public Boolean changePassword(Integer adminId, String newPassword) throws SQLException;

}
