package com.ele.view;

import cn.hutool.crypto.SecureUtil;
import com.ele.pojo.Business;
import com.ele.pojo.Food;
import com.ele.service.BusinessService;
import com.ele.service.FoodService;
import com.ele.service.Impl.BusinessServiceImpl;
import com.ele.service.Impl.FoodServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BusinessView {
    private static Scanner scanner = new Scanner(System.in);
    private static BusinessService businessService = new BusinessServiceImpl();
    private static FoodService foodService = new FoodServiceImpl();

    /**
     * 商家登陆界面
     */
    public void login() {
        System.out.println("请输入账号：");
        String businessName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        // 密码加密
        password = SecureUtil.md5(password + businessName);
        Business business = businessService.businessLogin(businessName, password);
        if (business == null) {
            System.out.println("账号或密码输入错误");
        } else {
            System.out.println("\uD83C\uDF54欢迎登录张飞快送\uD83C\uDF72");
            while (true) {
                System.out.println("请选择操作：1 添加食品 \t 2 查询食品列表 \t 3 修改商品信息 \t 4 删除商品信息 " +
                        "\t 5 修改商家信息 \t 6 查询商家信息 \t 7 退出");
                String op = scanner.nextLine();
                switch (op) {
                    case "1":
                        // 添加食品功能
                        addFood(business.getBusinessId());
                        break;
                    case "2":
                        // 查询食品列表功能
                        foodList(business.getBusinessId());
                        break;
                    case "3":
                        // 修改商品信息的功能
                        updateFood(business.getBusinessId());
                        break;
                    case "4":
                        // 删除商品信息的功能
                        deleteFood(business.getBusinessId());
                        break;
                    case "5":
                        // 修改商家信息的功能
                        updateBusiness(business);
                        break;
                    case "6":
                        // 查询商家信息的功能
                        System.out.println(business);
                        break;
                    case "7":
                        // 退出
                        return;
                    default:
                        System.out.println("请重新选择操作");
                }
            }
        }
    }

    /**
     *  删除食品信息
     * @param businessId 商家id
     */
    private void deleteFood(Integer businessId){
        System.out.println("当前旗下的食品有：");
        List<Food> foods = foodService.foodList(businessId);
        foods.forEach(System.out::println);
        System.out.println("请输入需要删除的食品编号：");
        String id = scanner.nextLine();
        boolean b = foodService.deleteFoodById(id);
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    /**
     *  修改食品信息
     * @param businessId 商家id
     */
    private void updateFood(Integer businessId){
        System.out.println("当前旗下的食品有：");
        List<Food> foods = foodService.foodList(businessId);
        foods.forEach(System.out::println);
        System.out.println("请选择需要修改的食品编号：");
        String foodId = scanner.nextLine();
        System.out.println("食品名称：");
        String foodName = scanner.nextLine();
        System.out.println("食品介绍：");
        String foodExplain = scanner.nextLine();
        System.out.println("食品价格：");
        String foodPrice = scanner.nextLine();
        System.out.println("食品状态：(1.上架 2.下架)");
        String foodStatus = scanner.nextLine();
        System.out.println("食品库存：");
        String foodStock = scanner.nextLine();

        // 封装为一个对象
        Food food = new Food();
        food.setFoodId(Integer.valueOf(foodId));
        food.setFoodName(foodName);
        food.setBusinessId(businessId);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));
        food.setFoodExplain(foodExplain);

        // 调用FoodService的updateFood方法
        boolean b = foodService.updateFood(food);
        if (b){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }


    /**
     * 查询商家的所有商品
     *
     * @param businessId 商家id
     */
    private void foodList(Integer businessId) {
        List<Food> foods = foodService.foodList(businessId);
        foods.forEach(System.out::println);

    }

    /**
     * 添加食品
     */
    public void addFood(Integer businessId) {
        System.out.println("食品名称");
        String foodName = scanner.nextLine();
        System.out.println("食品介绍");
        String foodExplain = scanner.nextLine();
        System.out.println("食品价格");
        String foodPrice = scanner.nextLine();
        System.out.println("食品状态:1 上架   2 下架");
        String foodStatus = scanner.nextLine();
        System.out.println("食品库存");
        String foodStock = scanner.nextLine();

        // 封装成对象
        Food food = new Food();
        food.setBusinessId(businessId);
        food.setFoodExplain(foodExplain);
        food.setFoodName(foodName);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setFoodStock(Integer.valueOf(foodStock));

        boolean b = foodService.addFood(food);
        if (b) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 商家注册界面
     */
    public void register() {
        System.out.println("请输入账号：");
        String businessName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        System.out.println("请输入地址：");
        String businessAddress = scanner.nextLine();
        System.out.println("请输入介绍：");
        String businessExplain = scanner.nextLine();
        System.out.println("请输入起送费：");
        String starPrice = scanner.nextLine();
        System.out.println("请输入配送费：");
        String deliveryPrice = scanner.nextLine();
        // 对密码进行加密
        password = SecureUtil.md5(password + businessName);
        Business business = new Business();
        business.setBusinessName(businessName);
        business.setPassword(password);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        business.setStarPrice(Double.valueOf(starPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.businessRegister(business);
        if (b) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }

    /**
     * 修改商家信息
     *
     * @param businesses 商家原有信息
     */
    public void updateBusiness(Business businesses) {
        System.out.println("商家原信息：" + businesses);
        System.out.println("请输入账号：");
        String businessName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        System.out.println("请输入地址：");
        String businessAddress = scanner.nextLine();
        System.out.println("请输入介绍：");
        String businessExplain = scanner.nextLine();
        System.out.println("请输入起送费：");
        String starPrice = scanner.nextLine();
        System.out.println("请输入配送费：");
        String deliveryPrice = scanner.nextLine();
        // 对密码进行加密
        password = SecureUtil.md5(password + businessName);
        businesses.setBusinessId(businesses.getBusinessId());
        businesses.setBusinessName(businessName);
        businesses.setPassword(password);
        businesses.setBusinessAddress(businessAddress);
        businesses.setBusinessExplain(businessExplain);
        businesses.setStarPrice(Double.valueOf(starPrice));
        businesses.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.updateBusiness(businesses);
        if (b) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }
}
