package com.ele.service.impl;

import com.ele.dao.BusinessDao;
import com.ele.dao.impl.BusinessDaoImpl;
import com.ele.pojo.Business;
import com.ele.service.BusinessService;

import java.sql.SQLException;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private static BusinessDao businessDao = new BusinessDaoImpl();
    /**
     *  查询所有商家信息
     * @return 所有商家的信息
     */
    @Override
    public List<Business> showBusinesses() {
       // 调用 BusinessDao的showBusiness()方法
        try{
            return businessDao.showBusinesses();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  根据商家id删除商家信息
     * @param businessId 商家编号
     * @return 删除成功或失败
     */
    @Override
    public Boolean deleteBusinessById(String businessId) {
        try {
            // 调用businessDao的deleteBusinessById()方法
            return businessDao.deleteBusinessById(businessId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  商家登录功能
     * @param businessName 商家名称
     * @param password 商家密码
     * @return 商家信息
     */
    @Override
    public Business login(String businessName, String password) {
        try{
            // 调用businessDao的login()方法
            return businessDao.login(businessName,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  商家注册功能
     * @param business 商家对象
     * @return 注册成功或失败
     */
    @Override
    public Boolean registerBusiness(Business business) {
        try{
            // 调用businessDao的registerBusiness()方法
            return businessDao.registerBusiness(business);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  修改商家个人信息
     * @param business 商家信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean changeBusiness(Business business) {
        try{
            // 调用businessDao的changeBusiness()方法
            return businessDao.changeBusiness(business);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
