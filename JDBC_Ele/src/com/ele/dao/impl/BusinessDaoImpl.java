package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.dao.BusinessDao;
import com.ele.pojo.Business;
import com.ele.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 商家类Dao接口的实现类
 */
public class BusinessDaoImpl implements BusinessDao {

    /**
     * 查询所有商家信息
     *
     * @return 所有商家信息
     */
    @Override
    public List<Business> showBusinesses() throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        List<Business> businesses = Db.use(ds).query("select * from business", Business.class);
        if (businesses.isEmpty()) {
            return null;
        }
        return businesses;
    }

    /**
     * 根据商家id删除商家信息
     *
     * @param businessId 商家编号
     * @return 删除成功或失败
     */
    @Override
    public Boolean deleteBusinessById(String businessId) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).del("business", "business_id", businessId);
        return i > 0;
    }

    /**
     * 商家登录功能
     *
     * @param businessName 商家名称
     * @param password     商家密码
     * @return 商家信息
     */
    @Override
    public Business login(String businessName, String password) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        List<Business> businesses = Db.use(ds).query("select * from business where business_name = ? and password = ?"
                , Business.class, businessName, password);
        if (businesses.isEmpty()) {
            return null;
        } else {
            return businesses.get(0);
        }
    }

    /**
     * 商家注册功能
     *
     * @param business 商家对象
     * @return 注册成功或失败
     */
    @Override
    public Boolean registerBusiness(Business business) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).insert(
                Entity.create("business")
                        .set("business_id", null)
                        .set("password", business.getPassword())
                        .set("business_name", business.getBusinessName())
                        .set("business_address", business.getBusinessAddress())
                        .set("business_explain", business.getBusinessExplain())
                        .set("star_price", business.getStarPrice())
                        .set("delivery_price", business.getDeliveryPrice())
        );
        return i > 0;
    }

    /**
     * 修改商家个人信息
     *
     * @param business 商家信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean changeBusiness(Business business) throws SQLException {
        DruidDataSource ds = JDBCUtils.getDruidSource();
        int i = Db.use(ds).update(
                Entity.create()
                        .set("password", business.getPassword())
                        .set("business_name", business.getBusinessName())
                        .set("business_address", business.getBusinessAddress())
                        .set("business_explain", business.getBusinessExplain())
                        .set("star_price", business.getStarPrice())
                        .set("delivery_price", business.getDeliveryPrice())
                , Entity.create("business").set("business_id", business.getBusinessId())
        );
        return i > 0;
    }
}
