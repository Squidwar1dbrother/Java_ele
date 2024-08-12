package com.ele.pojo;

/**
 * 食品类
 */
public class Food {

    /**
     * 食品编号
     */
    private Integer foodId;

    /**
     * 食品名称
     */
    private String foodName;

    /**
     * 食品介绍
     */
    private String foodExplain;

    /**
     * 食品价格
     */
    private Double foodPrice;

    /**
     * 所属商家编号
     */
    private Integer businessId;

    /**
     * 食品状态 1.上架  0.下架
     */
    private Integer foodStatus;

    /**
     * 食品库存
     */
    private Integer foodStock;

    @Override
    public String toString() {
        return "\uD83E\uDD58食品信息{" +
                "食品编号：" + foodId +
                ", 食品名称：" + foodName +
                ", 食品介绍：" + foodExplain +
                ", 食品价格：" + foodPrice +
                ", 食品所属商家编号：" + businessId +
                ", 食品状态：" + (foodStatus == 1 ? "上架" : "下架") +
                ", 食品库存：" + foodStock +
                '}';
    }

    public Food() {
    }

    public Food(Integer foodId, String foodName, String foodExplain
            , Double foodPrice, Integer businessId, Integer foodStatus, Integer foodStock) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
        this.foodStatus = foodStatus;
        this.foodStock = foodStock;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(Integer foodStatus) {
        this.foodStatus = foodStatus;
    }

    public Integer getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(Integer foodStock) {
        this.foodStock = foodStock;
    }
}
