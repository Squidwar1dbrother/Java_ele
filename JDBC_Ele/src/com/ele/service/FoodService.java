package com.ele.service;

import com.ele.pojo.Food;

import java.util.List;

/**
 *  FoodService接口
 */
public interface FoodService {

    /**
     * 查询食品列表
     * @param businessId 食品所属商家编号
     * @return 食品列表
     */
    public List<Food> showFood(Integer businessId);

    /**
     *  添加食品
     * @param food 食品信息
     * @return 添加成功或失败
     */
    public Boolean addFood(Food food);

    /**
     *  修改食品信息
     * @param food 食品信息
     * @return 修改成功或失败
     */
    public Boolean changeFood(Food food);

    /**
     *  删除食品信息
     * @param foodId 食品编号
     * @return 删除成功或失败
     */
    public Boolean deleteFood(String foodId);
}
