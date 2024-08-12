package com.ele.service.impl;

import com.ele.dao.FoodDao;
import com.ele.dao.impl.FoodDaoImpl;
import com.ele.pojo.Food;
import com.ele.service.FoodService;

import java.sql.SQLException;
import java.util.List;

/**
 *  FoodService接口的实现类
 */
public class FoodServiceImpl implements FoodService {
    private static FoodDao foodDao = new FoodDaoImpl();

    /**
     * 查询食品列表
     * @param businessId 食品所属商家编号
     * @return 食品列表
     */
    @Override
    public List<Food> showFood(Integer businessId) {
        try {
            // 调用foodDao的showFood()方法
            return foodDao.showFood(businessId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  添加食品
     * @param food 食品信息
     * @return 添加成功或失败
     */
    @Override
    public Boolean addFood(Food food) {
        try {
            // 调用foodDao的addFood()方法
            return foodDao.addFood(food);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  修改食品信息
     * @param food 食品信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean changeFood(Food food) {
        try {
            // 调用foodDao的changeFood()方法
            return foodDao.changeFood(food);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  删除食品信息
     * @param foodId 食品编号
     * @return 删除成功或失败
     */
    @Override
    public Boolean deleteFood(String foodId) {
        try {
            // 调用foodDao的deleteFood(FoodId)方法
            return foodDao.deleteFood(foodId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
