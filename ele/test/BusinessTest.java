package com.ele.test;

import cn.hutool.crypto.SecureUtil;
import com.ele.dao.BusinessDao;
import com.ele.dao.impl.BusinessDaoImpl;
import com.ele.pojo.Business;
import org.junit.jupiter.api.Test;


public class BusinessTest {
    public static void main(String[] args) throws Exception {
//        BusinessDao businessDao = new BusinessDaoImpl();
//        Business businesses = businessDao.businessLogin("沙县小吃", "123");
//        System.out.println(businesses);
        String businessName = "沙县小吃";
        String password = "123";
        password = SecureUtil.md5(password + businessName);
        System.out.println(password);
    }

    @Test
    public void getInsert() throws Exception {
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = new Business();
        business.setBusinessAddress("西八东岸");
        business.setBusinessName("美味小吃");
        business.setPassword("123");
        business.setBusinessExplain("美味实惠");
        business.setDeliveryPrice(3.0);
        business.setStarPrice(25.0);
        Boolean b = businessDao.businessRegister(business);
        System.out.println(b);
    }

    @Test
    public void getUpdate() throws Exception {
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = new Business();
        business.setBusinessId(2);
        business.setBusinessAddress("西岸");
        business.setBusinessName("美味");
        business.setPassword("123456");
        business.setBusinessExplain("昂贵好吃");
        business.setDeliveryPrice(15.0);
        business.setStarPrice(50.0);
        Boolean b = businessDao.updateBusiness(business);
        System.out.println(b);
    }
}
