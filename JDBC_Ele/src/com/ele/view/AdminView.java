package com.ele.view;

import cn.hutool.crypto.SecureUtil;
import com.ele.pojo.Admin;
import com.ele.pojo.Business;
import com.ele.service.AdminService;
import com.ele.service.BusinessService;
import com.ele.service.impl.AdminServiceImpl;
import com.ele.service.impl.BusinessServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 管理员页面
 */
public class AdminView {
    private static Scanner scanner = new Scanner(System.in);
    private static AdminService adminService = new AdminServiceImpl();
    private static BusinessService businessService = new BusinessServiceImpl();

    /**
     * 登录功能
     */
    public void login() {

        System.out.println("请输入管理员姓名：");
        String adminName = scanner.nextLine();
        System.out.println("请输入管理员密码：");
        String password = scanner.nextLine();
        // 密码加密
        password = SecureUtil.md5(password + adminName);
        // 调用AdminService的登录方法
        Admin admin = adminService.adminLogin(adminName, password);
        if (admin == null) {
            System.out.println("账号或密码输入不正确，请重新输入");
        } else {
            System.out.println("欢迎管理员：" + admin.getAdmin_name());
            while (true) {
                System.out.println("请选择要进行的操作： 1. 查看所有商家信息  2. 删除商家信息  3. 修改个人密码  4. 退出");
                String one = scanner.nextLine();
                switch (one) {
                    case "1":
                        // 调用本类的getBusinesses()方法
                        getBusinesses();
                        break;
                    case "2":
                        // 调用本类的deleteBusiness()方法
                        deleteBusiness();
                        break;
                    case "3":
                        // 调用本类的updatePassword()方法
                        updatePassword(admin);
                        break;
                    case "4":
                        // 退出
                        return;
                    default:
                        System.out.println("操作有误，请重新选择");
                }
            }

        }
    }

    /**
     *  根据id删除商家信息
     */
    private void deleteBusiness() {
        System.out.println("所有商家的信息如下：");
        List<Business> businesses = businessService.showBusinesses();
        businesses.forEach(System.out::println);
        System.out.println("请输入要删除的商家编号：");
        String id = scanner.nextLine();
        System.out.println("确认是否删除 (YES/NO)");
        String sc = scanner.nextLine();
        if ("yes".equalsIgnoreCase(sc)){
            // 调用businessService的deleteBusinessById()方法
            Boolean b = businessService.deleteBusinessById(id);
            if (b){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
    }

    /**
     *  管理员修改个人密码
     */
    private void updatePassword(Admin admin) {
        Boolean b = false;
        do { System.out.println("请输入原密码：");
            String oldPassword = scanner.nextLine();
            System.out.println("请输入新密码：");
            String newPassword = scanner.nextLine();
            System.out.println("请确认密码：");
            String confirmPassword = scanner.nextLine();

            // 判断密码是否有误
            oldPassword = SecureUtil.md5(oldPassword + admin.getAdmin_name());
            if (oldPassword.equals(admin.getPassword())){
                if (newPassword.equals(oldPassword)){
                    System.out.println("新密码不可与原密码一致");
                }else {
                    if (newPassword.equals(confirmPassword)){
                        // 密码加密
                        newPassword = SecureUtil.md5(newPassword + admin.getAdmin_name());
                        // 调用adminService的changePassword()方法
                         b = adminService.changePassword(admin.getAdmin_id(),newPassword);
                        if (b){
                            System.out.println("修改成功");
                        }else {
                            System.out.println("修改失败");
                        }
                    }else {
                        System.out.println("两次密码输入不一致");
                    }
                }
            }else {
                System.out.println("输入的原密码有误");
            }}while (!b);
    }

    /**
     *  调用businessService的showBusiness()方法
     *  查询所有商家信息
     */
    private void getBusinesses() {
        List<Business> businesses = businessService.showBusinesses();
        businesses.forEach(System.out::println);
    }
}
