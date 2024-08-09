package com.ele.dao;

import com.ele.pojo.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {

    /**
     *  添加食品
     * @param food 食品
     * @return 添加成功或失败
     */
    public boolean addFood(Food food) throws SQLException;

    /**
     *  查询商家的所有食品信息
     * @param businessId 商家id
     * @return 所有食品信息
     */
    public List<Food> foodList(Integer businessId)throws SQLException;

    /**
     *  修改食品信息
     * @param food 修改的食品信息
     * @return 修改成功或失败
     */
    public boolean updateFood(Food food) throws SQLException;

    /**
     *  删除食品信息
     * @param id 食品编号
     * @return 删除成功或失败
     */
    public boolean deleteFoodById(String id) throws SQLException;
}
