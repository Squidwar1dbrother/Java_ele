package com.ele.service;

import com.ele.pojo.Admin;

/**
 *  管理员service接口
 */
public interface AdminService {
    /**
     *  管理员登录功能
     * @param adminName 管理员账号
     * @param password 管理员密码
     * @return 管理员界面
     */
    public Admin adminLogin(String adminName,String password);

    /**
     *  管理员修改自己的密码功能
     * @param adminId 管理员id
     * @param newPassword 新密码
     * @return 修改成功或失败
     */
    public Boolean changePassword(Integer adminId, String newPassword);
}
