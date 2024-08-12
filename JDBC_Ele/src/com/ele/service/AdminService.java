package com.ele.service;

import com.ele.pojo.Admin;

/**
 *  管理员的service接口
 */
public interface AdminService {

    /**
     *  管理员登陆方法
     */
    public Admin adminLogin(String adminName, String password);

    /**
     *  管理员修改个人密码
     * @param admin_id 管理员编号
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    public Boolean changePassword(Integer admin_id, String newPassword);
}
