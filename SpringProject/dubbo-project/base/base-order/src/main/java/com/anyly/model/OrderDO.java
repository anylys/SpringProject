package com.anyly.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author anyly
 * 订单类
 */
public class OrderDO implements Serializable {
    private Integer id;
    private Integer userId;
    private String shopName;
    private BigDecimal shopPrice;
    private Integer payStatus;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                ", payStatus=" + payStatus +
                ", userId=" + userId +
                '}';
    }
}
