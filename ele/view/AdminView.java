package com.ele.view;

import com.ele.pojo.Admin;
import com.ele.pojo.Business;
import com.ele.service.AdminService;
import com.ele.service.BusinessService;
import com.ele.service.Impl.AdminServiceImpl;
import com.ele.service.Impl.BusinessServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 管理员窗口
 */
public class AdminView {

    private static Scanner scanner = new Scanner(System.in);
    private static AdminService adminService = new AdminServiceImpl();
    private static BusinessService businessService = new BusinessServiceImpl();

    public void login() {
        System.out.println("请输入管理员账号：");
        String adminName = scanner.nextLine();
        System.out.println("请输入管理员密码：");
        String password = scanner.nextLine();
        Admin admin = adminService.adminLogin(adminName, password);
        if (admin == null) {
            System.out.println("账号或密码输入错误");
        } else {
            System.out.println("欢迎管理员：" + admin.getAdminName());
            while (true) {
                System.out.println("请输入需要进行的操作： 1.查看所有商家  2.删除商家  3.修改密码  4.退出");
                String sp = scanner.nextLine();
                switch (sp) {
                    case "1":
                        //查看所有商家
                        getBusiness();
                        break;
                    case "2":
                        // 删除商家
                        deleteBusiness();
                        break;
                    case "3":
                        //修改密码
                        changePassword(admin);
                        break;
                    case "4":
                        //退出
                        return;
                    default:
                        System.out.println("输入错误，请重新选择");
                }
            }
        }
    }

    /**
     *  修改管理员自己的密码
     * @param admin 管理员
     */
    private void changePassword(Admin admin) {
        System.out.println("请输入原密码：");
        String oldPassword = scanner.nextLine();
        System.out.println("请输入新密码：");
        String newPassword = scanner.nextLine();
        System.out.println("请确认密码：");
        String confirmPassword = scanner.nextLine();

        // 对输入的密码进行判断
        if (oldPassword.equals(admin.getPassword())){
            if (newPassword.equals(confirmPassword)){
                if (newPassword.equals(admin.getPassword())){
                    System.out.println("新密码不可与原密码一致");
                }else {
                 Boolean b =   adminService.changePassword(admin.getAdminId(),newPassword);
                if (b){
                    System.out.println("修改成功");
                    admin.setPassword(newPassword);
                }else {
                    System.out.println("修改失败");
                }
                }
            }else {
                System.out.println("两次密码输入不一致");
            }
        }else {
            System.out.println("输入的原密码有误");
        }
    }

    /**
     *  根据id删除商家
     */
    private void deleteBusiness() {
        System.out.println("确定要删除吗？(yes/no)");
        String delete = scanner.nextLine();
        if ("yes".equalsIgnoreCase(delete)){
            System.out.println("请输入商家编号：");
            String id = scanner.nextLine();
            boolean b = businessService.deleteBusinessById(id);
            if (b){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
    }

    /**
     *  查看所有商家信息
     */
    public void getBusiness(){
        List<Business> businesses = businessService.businesses();
        businesses.forEach(System.out::println);
    }
}
