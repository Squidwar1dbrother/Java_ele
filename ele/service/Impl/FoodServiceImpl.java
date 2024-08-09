package com.ele.service.Impl;

import cn.hutool.db.Db;
import com.ele.dao.FoodDao;
import com.ele.dao.impl.FoodDaoImpl;
import com.ele.pojo.Food;
import com.ele.service.FoodService;
import com.ele.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class FoodServiceImpl implements FoodService {
private static FoodDao foodDao = new FoodDaoImpl();
    /**
     *  添加食品
     * @param food 食品
     * @return 添加成功或失败
     */
    @Override
    public boolean addFood(Food food) {
        try {
            return foodDao.addFood(food);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     *  查询商家的所有食品信息
     * @param businessId 商家id
     * @return 所有食品信息
     */
    @Override
    public List<Food> foodList(Integer businessId) {
        try {
            return foodDao.foodList(businessId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  修改食品信息
     * @param food 修改的食品信息
     * @return 修改成功或失败
     */
    @Override
    public boolean updateFood(Food food) {
        try {
            return foodDao.updateFood(food);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     *  删除食品信息
     * @param id 食品编号
     * @return 删除成功或失败
     */
    @Override
    public boolean deleteFoodById(String id) {
        try {
            return foodDao.deleteFoodById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
