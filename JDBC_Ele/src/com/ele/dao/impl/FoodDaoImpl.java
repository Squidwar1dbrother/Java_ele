package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.dao.FoodDao;
import com.ele.pojo.Food;
import com.ele.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * FoodDao的实现类
 */
public class FoodDaoImpl implements FoodDao {

    /**
     * 查询食品列表
     *
     * @param businessId 食品所属商家编号
     * @return 食品列表
     */
    @Override
    public List<Food> showFood(Integer businessId) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        List<Food> foods = Db.use(ds).query("select * from food where business_id = ?", Food.class, businessId);
        if (foods.isEmpty()) {
            return null;
        }
        return foods;
    }

    /**
     * 添加食品
     *
     * @param food 食品信息
     * @return 添加成功或失败
     */
    @Override
    public Boolean addFood(Food food) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).insert(
                Entity.create("food").set("food_id", null).set("food_name", food.getFoodName())
                        .set("food_explain", food.getFoodExplain()).set("food_price", food.getFoodPrice())
                        .set("business_id", food.getBusinessId()).set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock())
        );
        return i > 0;
    }

    /**
     * 修改食品信息
     *
     * @param food 食品信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean changeFood(Food food) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).update(
                Entity.create().set("food_name", food.getFoodName())
                        .set("food_explain", food.getFoodExplain()).set("food_price", food.getFoodPrice())
                        .set("business_id", food.getBusinessId()).set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock())
                , Entity.create("food").set("food_id", food.getFoodId())
        );
        return i > 0;
    }

    /**
     * 删除食品信息
     *
     * @param foodId 食品编号
     * @return 删除成功或失败
     */
    @Override
    public Boolean deleteFood(String foodId) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).del("food", "food_id", foodId);
        return i > 0;
    }
}
