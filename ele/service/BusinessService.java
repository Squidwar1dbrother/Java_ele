package com.ele.service;

import com.ele.pojo.Business;

import java.util.List;

/**
 *  商家service接口
 */
public interface BusinessService {
    /**
     * 商家登陆功能
     *
     * @param businessName 商家账号
     * @param password     商家密码
     * @return 商家信息
     */
    public Business businessLogin(String businessName, String password);

    /**
     * 商家注册功能
     *
     * @return 注册信息
     */
    public Boolean businessRegister(Business business);

    /**
     * 商家修改信息功能
     *
     * @param business 商家需要修改的信息
     * @return 修改成功或失败
     */
    public Boolean updateBusiness(Business business);

    /**
     *  查询所有商家功能
     * @return 商家信息
     */
    public List<Business> businesses();

    /**
     *  根据id删除商家信息
     * @param id 商家id
     * @return 删除成功或失败
     */
    public boolean deleteBusinessById(String id);
}
