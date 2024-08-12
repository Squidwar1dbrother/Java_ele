package com.ele;

import com.ele.view.AdminView;
import com.ele.view.BusinessView;

import java.util.Scanner;

/**
 *  App展示界面
 */
public class EleApp {
    private static AdminView adminView = new AdminView();
    private static BusinessView businessView = new BusinessView();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎登陆曹操跑腿外卖系统");
        while (true){
        System.out.println("请选择登录方式： 1. 管理员登录  2. 商家登录  3. 商家注册 4. 退出");
        String one = scanner.nextLine();
            switch (one){
                case "1":
                    // 调用管理员登陆的功能
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
                    // 退出
                    return;
                default:
                    System.out.println("选择错误，请重新选择");
            }
        }
    }
}
