package com.ele.pojo;

/**
 * 商家类
 */
public class Business {

    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 商家密码
     */
    private String password;

    /**
     * 商家地址
     */
    private String businessAddress;

    /**
     * 商家介绍
     */
    private String businessExplain;

    /**
     * 起送费
     */
    private Double starPrice;

    /**
     * 配送费
     */
    private Double deliveryPrice;

    @Override
    public String toString() {
        return "\uD83C\uDFEA商家信息{" +
                "商家编号：" + businessId +
                ", 商家名称：" + businessName +
                ", 商家密码(已加密)：" + password +
                ", 商家地址：" + businessAddress +
                ", 商家介绍：" + businessExplain +
                ", 起送费：" + starPrice +
                ", 配送费：" + deliveryPrice +
                '}';
    }

    public Business() {
    }

    public Business(Integer businessId, String businessName, String password, String businessAddress
            , String businessExplain, Double starPrice, Double deliveryPrice) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.password = password;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public Double getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
}
