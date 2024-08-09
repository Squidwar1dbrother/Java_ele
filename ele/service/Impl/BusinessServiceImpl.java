package com.ele.service.Impl;

import cn.hutool.crypto.SecureUtil;
import com.ele.dao.BusinessDao;
import com.ele.dao.impl.BusinessDaoImpl;
import com.ele.pojo.Business;
import com.ele.service.BusinessService;

import java.sql.SQLException;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {

    private BusinessDao businessDao = new BusinessDaoImpl();

    /**
     * 商家登陆功能
     *
     * @param businessName 商家账号
     * @param password     商家密码
     * @return 商家信息
     */
    @Override
    public Business businessLogin(String businessName, String password) {
        try {
            // 调用businessDaoImpl的登录方法
            return businessDao.businessLogin(businessName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 商家注册功能
     *
     * @return 注册信息
     */
    @Override
    public Boolean businessRegister(Business business) {
        try {
            // 调用businessDaoImpl的注册方法
            return businessDao.businessRegister(business);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 商家修改信息功能
     *
     * @param business 商家需要修改的信息
     * @return 修改成功或失败
     */
    @Override
    public Boolean updateBusiness(Business business) {
        try {
            // 调用businessDaoImpl的修改信息方法
            return businessDao.updateBusiness(business);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  查询所有商家功能
     * @return 商家信息
     */
    @Override
    public List<Business> businesses() {
        try {
            // 调用businessDaoImpl的查询所有信息方法
            return businessDao.businesses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  根据id删除商家信息
     * @param id 商家id
     * @return 删除成功或失败
     */
    @Override
    public boolean deleteBusinessById(String id) {
        try {
            return businessDao.deleteBusinessById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
