package com.anyly.service.impl;

import com.anyly.annotation.DataSourceSwitch;

import com.anyly.order.mapper.OrderMapper;
import com.anyly.order.model.OrderEntity;
import com.anyly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author lishengorng
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @DataSourceSwitch
    @Override
    public List<OrderEntity> allOrder() {
        return orderMapper.allOrder();
    }
}
