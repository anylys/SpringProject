package com.anyly.controller;

import com.anyly.order.model.OrderEntity;
import com.anyly.service.OrderService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author  anyly
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    public OrderService orderService;
    Logger logger = Logger.getLogger(this.getClass());
    @GetMapping("info")
    public List<OrderEntity> allOrder(){
        List<OrderEntity> list = orderService.allOrder();
        logger.info(list.size());
        return list;
    }

}
