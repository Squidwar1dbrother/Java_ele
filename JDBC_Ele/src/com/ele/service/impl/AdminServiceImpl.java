package com.ele.service.impl;

import com.ele.dao.AdminDao;
import com.ele.dao.impl.AdminDaoImpl;
import com.ele.pojo.Admin;
import com.ele.service.AdminService;

import java.sql.SQLException;

/**
 * 管理员Service接口的实现类
 */
public class AdminServiceImpl implements AdminService {
    private static AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登陆方法
     *
     * @param adminName 管理员姓名
     * @param password  管理员密码
     */
    @Override
    public Admin adminLogin(String adminName, String password) {
        // 调用AdminDao的登陆方法
        try {
            return adminDao.AdminLogin(adminName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  管理员修改个人密码
     * @param admin_id 管理员编号
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    @Override
    public Boolean changePassword(Integer admin_id, String newPassword) {
        try{
            // 调用adminDao的changePassword()方法
           return adminDao.changePassword(admin_id,newPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
