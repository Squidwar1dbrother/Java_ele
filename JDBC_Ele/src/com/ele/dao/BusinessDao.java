package com.ele.dao;

import com.ele.pojo.Business;

import java.sql.SQLException;
import java.util.List;

/**
 * 商家类的Dao接口
 */
public interface BusinessDao {

    /**
     * 查询所有商家信息
     *
     * @return 所有商家信息
     */
    public List<Business> showBusinesses() throws SQLException;

    /**
     * 根据商家id删除商家信息
     *
     * @param businessId 商家编号
     * @return 删除成功或失败
     */
    public Boolean deleteBusinessById(String businessId) throws SQLException;

    /**
     * 商家登录功能
     *
     * @param businessName 商家名称
     * @param password     商家密码
     * @return 商家信息
     */
    public Business login(String businessName, String password) throws SQLException;

    /**
     * 商家注册功能
     *
     * @param business 商家对象
     * @return 注册成功或失败
     */
    public Boolean registerBusiness(Business business) throws SQLException;

    /**
     * 修改商家个人信息
     *
     * @param business 商家信息
     * @return 修改成功或失败
     */
    public Boolean changeBusiness(Business business) throws SQLException;
}
