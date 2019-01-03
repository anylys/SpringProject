package com.anyly.service.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lishengrong
 */
public class OrderBO implements Serializable {
    private Integer id;
    private String shopName;
    private BigDecimal shopPrice;
    private Integer payStatus;
    private Integer userId;

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
        return "OrderBO{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                '}';
    }
}
