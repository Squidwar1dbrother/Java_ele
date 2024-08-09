package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.ele.dao.FoodDao;
import com.ele.pojo.Food;
import com.ele.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class FoodDaoImpl implements FoodDao {

    /**
     * 添加食品
     *
     * @param food 食品
     * @return 添加成功或失败
     */
    @Override
    public boolean addFood(Food food) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).insert(
                Entity.create("food").set("food_id", null).set("food_name", food.getFoodName())
                        .set("food_explain", food.getFoodExplain()).set("food_price", food.getFoodPrice())
                        .set("business_id", food.getBusinessId()).set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock())
        );
        return i == 1;
    }

    /**
     * 查询商家的所有食品信息
     *
     * @param businessId 商家id
     * @return 所有食品信息
     */
    @Override
    public List<Food> foodList(Integer businessId) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        return Db.use(ds).query("select * from food where business_id = ?", Food.class, businessId);
    }

    /**
     * 修改食品信息
     *
     * @param food 修改的食品信息
     * @return 修改成功或失败
     */
    @Override
    public boolean updateFood(Food food) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).update(
                Entity.create().set("food_id", food.getFoodId())
                        .set("food_name", food.getFoodName())
                        .set("food_explain", food.getFoodExplain())
                        .set("food_price", food.getFoodPrice())
                        .set("business_id", food.getBusinessId())
                        .set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock())
                , Entity.create("food").set("food_id", food.getFoodId())
        );
        return i == 1;
    }

    /**
     * 删除食品信息
     *
     * @param id 食品编号
     * @return 删除成功或失败
     */
    @Override
    public boolean deleteFoodById(String id) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).del("food", "food_id", id);
        return i > 0;
    }
}
