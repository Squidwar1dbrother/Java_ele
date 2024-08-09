package com.ele.dao.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.dao.BusinessDao;
import com.ele.pojo.Business;
import com.ele.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    /**
     * 商家登陆功能
     *
     * @param businessName 商家账号
     * @param password     商家密码
     * @return 商家信息
     */
    @Override
    public Business businessLogin(String businessName, String password) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_ele", "root", "root");
        String sql = "select * from business where business_name = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, businessName);

        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            // 登录成功
            Business business = new Business();
            // 封装查询到的商家的数据
            business.setBusinessId(rs.getInt("business_id"));
            business.setBusinessName(rs.getString("business_name"));
            business.setPassword(rs.getString("password"));
            business.setBusinessAddress(rs.getString("business_address"));
            business.setBusinessExplain(rs.getString("business_explain"));
            business.setStarPrice(rs.getDouble("star_price"));
            business.setDeliveryPrice(rs.getDouble("delivery_price"));
            return business;
        } else {
            return null;
        }
    }

    /**
     * 商家注册功能
     *
     * @return 注册信息
     */
    @Override
    public Boolean businessRegister(Business business) throws Exception {
        // 创建Druid对象
        DruidDataSource ds = new DruidDataSource();
        // 加载驱动参数和数据库连接参数
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setUsername("root");
        ds.setPassword("root");
        // 使用hutool建立SQL语句
        int i = Db.use(ds).insert(
                Entity.create("business").set("password", business.getPassword())
                        .set("business_name", business.getBusinessName())
                        .set("business_address", business.getBusinessAddress())
                        .set("business_explain", business.getBusinessExplain())
                        .set("star_price", business.getStarPrice())
                        .set("delivery_price", business.getDeliveryPrice())
        );
        return i > 0;
    }

    /**
     * 商家修改信息功能
     *
     * @param business 商家需要修改的信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean updateBusiness(Business business) throws Exception {
        // 创建Druid对象
        DruidDataSource ds = new DruidDataSource();
        // 加载驱动参数和数据库连接参数
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setUsername("root");
        ds.setPassword("root");
        // 使用hutool建立SQL语句
        int i = Db.use(ds).update(
                Entity.create().set("business_id", business.getBusinessId())
                        .set("password", business.getPassword())
                        .set("business_name", business.getBusinessName())
                        .set("business_address", business.getBusinessAddress())
                        .set("business_explain", business.getBusinessExplain())
                        .set("star_price", business.getStarPrice())
                        .set("delivery_price", business.getDeliveryPrice())
                , Entity.create("business").set("business_id", business.getBusinessId())
        );

        return i == 1;
    }

    /**
     * 查询所有商家信息的功能
     *
     * @return 商家信息
     */
    @Override
    public List<Business> businesses() throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        List<Business> businesses = Db.use(ds).query("select * from business", Business.class);
        return businesses;
    }

    /**
     * 根据id删除商家信息
     *
     * @param id 商家id
     * @return 删除成功或失败
     */
    @Override
    public boolean deleteBusinessById(String id) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).del("business", "business_id", id);
        return i == 1;
    }
}
