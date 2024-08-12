package com.ele.service;

import com.ele.pojo.Business;

import java.util.List;

/**
 *  商家类的service 接口
 */
public interface BusinessService {

    /**
     *  查询所有商家信息
     * @return 所有商家的信息
     */
    public List<Business> showBusinesses();

    /**
     *  根据商家id删除商家信息
     * @param businessId 商家编号
     * @return 删除成功或失败
     */
    public Boolean deleteBusinessById(String businessId);

    /**
     *  商家登录功能
     * @param businessName 商家名称
     * @param password 商家密码
     * @return 商家信息
     */
    public Business login(String businessName, String password);

    /**
     *  商家注册功能
     * @param business 商家对象
     * @return 注册成功或失败
     */
    public Boolean registerBusiness(Business business);

    /**
     *  修改商家个人信息
     * @param business 商家信息
     * @return 修改成功或失败
     */
    public Boolean changeBusiness(Business business);
}
