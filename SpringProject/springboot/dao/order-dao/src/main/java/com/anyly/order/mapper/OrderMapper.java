package com.anyly.order.mapper;

import com.anyly.order.model.OrderEntity;

import java.util.List;

/**
 * @author lishengrong
 */
public interface OrderMapper {
    List<OrderEntity> allOrder();
    int addOrder(OrderEntity orderEntity);
}
