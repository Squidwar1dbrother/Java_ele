package com.ele.service.Impl;

import com.ele.dao.AdminDao;
import com.ele.dao.impl.AdminDaoImpl;
import com.ele.pojo.Admin;
import com.ele.service.AdminService;

import java.sql.SQLException;

/**
 * 管理员service的实现类
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录功能
     *
     * @param adminName 管理员账号
     * @param password  管理员密码
     * @return 管理员界面
     */
    @Override
    public Admin adminLogin(String adminName, String password) {
        try {
            return adminDao.adminLogin(adminName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 管理员修改自己的密码功能
     *
     * @param adminId     管理员id
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    @Override
    public Boolean changePassword(Integer adminId, String newPassword) {
        try {
            return adminDao.changePassword(adminId, newPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
