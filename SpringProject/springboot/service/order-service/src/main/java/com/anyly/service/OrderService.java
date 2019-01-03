package com.anyly.service;

import com.anyly.order.model.OrderEntity;

import java.util.List;

/**
 * @author lishengorng
 */
public interface OrderService {
    public List<OrderEntity> allOrder();
}
