package com.ele;

import com.ele.view.AdminView;
import com.ele.view.BusinessView;

import java.util.Scanner;

/**
 * 项目的入口程序，启动这个类，开启这个项目
 */
public class EleApp {
    private static BusinessView businessView = new BusinessView();
    private static AdminView adminView = new AdminView();

    public static void main(String[] args) {
        System.out.println("欢迎使用张飞快送外卖管理系统");
        // 需要获取控制台输入的登录的方式：1 或者 2
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择登录方式：1 管理员登录 \t  2 商家登录 \t 3 商家注册 \t 4 退出");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    // 管理员的功能
                    adminView.login();
                    break;
                case "2":
                    // 调用商家登录的功能
                    businessView.login();
                    break;
                case "3":
                    // 调用商家注册的功能
                    businessView.register();
                    break;
                case "4":
                    //System.exit(0);
                    return;
                default:
                    System.out.println("输出错误，请重新选择登录方式");
                    break;
            }
        }

    }
}

