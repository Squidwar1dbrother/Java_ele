package com.ele.pojo;

/**
 *  食品类
 */
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;
    private Integer foodStatus;
    private Integer foodStock;

    @Override
    public String toString() {
        return "Food{" +
                "食品编号：" + foodId +
                ", 食品名称：" + foodName +
                ", 食品介绍：" + foodExplain  +
                ", 食品价格：" + foodPrice +
                ", 食品商家编号：" + businessId +
                ", 食品状态：" + (foodStatus == 1 ? "上架":"下架") +
                ", 食品库存：" + foodStock +
                '}';
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

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }
}
