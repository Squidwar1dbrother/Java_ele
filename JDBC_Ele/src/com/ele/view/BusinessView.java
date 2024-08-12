package com.ele.view;

import cn.hutool.crypto.SecureUtil;
import com.ele.pojo.Business;
import com.ele.pojo.Food;
import com.ele.service.BusinessService;
import com.ele.service.FoodService;
import com.ele.service.impl.BusinessServiceImpl;
import com.ele.service.impl.FoodServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BusinessView {
    private static Scanner scanner = new Scanner(System.in);
    private static BusinessService businessService = new BusinessServiceImpl();
    private static FoodService foodService = new FoodServiceImpl();

    /**
     * 商家登录功能
     */
    public void login() {
        System.out.println("请输入商家名称：");
        String businessName = scanner.nextLine();
        System.out.println("请输入商家密码");
        String password = scanner.nextLine();
        // 密码加密
        password = SecureUtil.md5(password + businessName);

        // 调用businessService的login()方法
        Business business = businessService.login(businessName, password);
        if (business != null) {
            System.out.println("\uD83C\uDFEA欢迎商家：" + business.getBusinessName());
            while (true) {
                System.out.println("请选择要进行的操作： 1. 查询食品列表  2. 添加食品  3. 修改食品信息  4. 删除食品信息" +
                        "  5.修改商家个人信息  6. 查询商家个人信息  7. 退出 ");
                String one = scanner.nextLine();
                switch (one) {
                    case "1":
                        // 查询食品列表
                        showFood(business.getBusinessId());
                        break;
                    case "2":
                        // 添加食品
                        addFood(business.getBusinessId());
                        break;
                    case "3":
                        // 修改食品信息
                        changeFood(business.getBusinessId());
                        break;
                    case "4":
                        // 删除食品信息
                        deleteFood(business.getBusinessId());
                        break;
                    case "5":
                        // 修改商家个人信息
                        updateBusiness(business);
                        break;
                    case "6":
                        // 查询商家个人信息
                        System.out.println(business);
                        break;
                    case "7":
                        // 退出
                        return;
                    default:
                        System.out.println("选择有误");
                }
            }

        } else {
            System.out.println("账号或密码输入错误");
        }

    }

    /**
     *  删除食品功能
     * @param businessId 所属商家id
     */
    private void deleteFood(Integer businessId) {
        System.out.println("以下是该商铺的食品列表");
        List<Food> foods = foodService.showFood(businessId);
        foods.forEach(System.out::println);
        System.out.println("请输入要删除的食品编号：");
        String one = scanner.nextLine();
        System.out.println("确定要删除吗？(YES/NO)");
        String yn = scanner.nextLine();
        if ("yes".equalsIgnoreCase(yn)){
            Boolean b = foodService.deleteFood(one);
            if (b){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
    }

    /**
     *  修改食品功能
     * @param businessId 所属商家id
     */
    private void changeFood(Integer businessId) {
        System.out.println("以下是该商铺的食品列表");
        List<Food> foods = foodService.showFood(businessId);
        foods.forEach(System.out::println);
        System.out.println("请输入要修改的食品编号：");
        String one = scanner.nextLine();
        System.out.println("请输入食品名称：");
        String foodName = scanner.nextLine();
        System.out.println("请输入食品介绍：");
        String foodExplain = scanner.nextLine();
        System.out.println("请输入食品价格：");
        String foodPrice = scanner.nextLine();
        System.out.println("请输入食品状态：(1. 上架 0. 下架)");
        String foodStatus = scanner.nextLine();
        System.out.println("请输入食品库存：");
        String foodStock = scanner.nextLine();

        // 封装为一个food对象
        Food food = new Food();
        food.setFoodId(Integer.valueOf(one));
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setBusinessId(businessId);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));

        Boolean b = foodService.changeFood(food);
        if (b){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    /**
     *  添加食品功能
     * @param businessId 商家编号
     */
    private void addFood(Integer businessId) {
        System.out.println("请输入食品名称：");
        String foodName = scanner.nextLine();
        System.out.println("请输入食品介绍：");
        String foodExplain = scanner.nextLine();
        System.out.println("请输入食品价格：");
        String foodPrice = scanner.nextLine();
        System.out.println("请输入食品状态：(1. 上架 0. 下架)");
        String foodStatus = scanner.nextLine();
        System.out.println("请输入食品库存：");
        String foodStock = scanner.nextLine();

        // 封装为一个food对象
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setBusinessId(businessId);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));

        Boolean b = foodService.addFood(food);
        if (b){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    /**
     *  查询食品列表
     * @param businessId 食品所属商家列表
     */
    private void showFood(Integer businessId) {
        // 调用foodService的showFood()方法
       List<Food> foods = foodService.showFood(businessId);
        // 如果食品列表为空，则捕获异常
       try {
           foods.forEach(System.out::println);
       }catch (NullPointerException e){
           System.out.println("当前食品列表为空");
       }

    }

    /**
     * 修改商家个人信息
     *
     * @param business 商家
     */
    private void updateBusiness(Business business) {
        System.out.println("请输入商家名称：");
        String businessName = scanner.nextLine();
        System.out.println("请输入商家密码：");
        String password = scanner.nextLine();
        System.out.println("请输入商家地址：");
        String businessAddress = scanner.nextLine();
        System.out.println("请输入商家介绍：");
        String businessExplain = scanner.nextLine();
        System.out.println("请输入起送费：");
        String starPrice = scanner.nextLine();
        System.out.println("请输入配送费：");
        String deliveryPrice = scanner.nextLine();


        // 密码加密
        password = SecureUtil.md5(password + businessName);

        // 重新赋值
        business.setBusinessName(businessName);
        business.setPassword(password);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        business.setStarPrice(Double.valueOf(starPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));

        // 调用businessService的changeBusiness()方法
        Boolean b = businessService.changeBusiness(business);
        if (b) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }


    /**
     * 商家注册功能
     */
    public void register() {
        System.out.println("请输入商家名称：");
        String businessName = scanner.nextLine();
        System.out.println("请输入商家密码：");
        String password = scanner.nextLine();
        System.out.println("请输入商家地址：");
        String businessAddress = scanner.nextLine();
        System.out.println("请输入商家介绍：");
        String businessExplain = scanner.nextLine();
        System.out.println("请输入起送费：");
        String starPrice = scanner.nextLine();
        System.out.println("请输入配送费：");
        String deliveryPrice = scanner.nextLine();

        // 密码加密
        password = SecureUtil.md5(password + businessName);

        // 封装成一个对象
        Business business = new Business();
        business.setBusinessName(businessName);
        business.setPassword(password);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        business.setStarPrice(Double.valueOf(starPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));

        // 调用businessService的registerBusiness()方法
        Boolean b = businessService.registerBusiness(business);
        if (b) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }
}
