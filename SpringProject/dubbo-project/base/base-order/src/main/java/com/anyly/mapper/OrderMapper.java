package com.anyly.mapper;

import com.anyly.model.OrderDO;

import java.util.List;

/**
 * @author anyly
 */
public interface OrderMapper {
    int updateOrder(OrderDO orderDO);

    OrderDO getOrder(Integer id);

    List<OrderDO> allOrder();
}
