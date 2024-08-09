package com.ele.service;

import com.ele.pojo.Food;

import java.util.List;

public interface FoodService {

    /**
     *  添加食品
     * @param food 食品
     * @return 添加成功或失败
     */
    public  boolean addFood(Food food);

    /**
     *  查询所有食品
     */
    public List<Food> foodList(Integer businessId);

    /**
     *  修改食品信息
     * @param food 修改的食品信息
     * @return 修改成功或失败
     */
    public boolean updateFood(Food food);

    /**
     *  删除食品信息
     * @param id 食品编号
     * @return 删除成功或失败
     */
    public boolean deleteFoodById(String id);

}
