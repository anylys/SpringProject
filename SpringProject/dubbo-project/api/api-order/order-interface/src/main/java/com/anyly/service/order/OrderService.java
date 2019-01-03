package com.anyly.service.order;

import com.anyly.service.order.bo.OrderBO;

import java.util.List;

public interface OrderService {
    public List<OrderBO> allOrder();

    public Boolean pay(OrderBO orderDO);

    public OrderBO getOrder(Integer id);
}
