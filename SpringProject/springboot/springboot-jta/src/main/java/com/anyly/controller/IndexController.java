package com.anyly.controller;


import com.anyly.order.model.OrderEntity;
import com.anyly.service.OrderService;
import com.anyly.service.UserService;

import com.anyly.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author  anyly
 */
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @GetMapping("test1")
    public String test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("anyly");
        userEntity.setBalance(new BigDecimal(1000));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPayStatus(0);
        orderEntity.setShopName("Iphone 20");
        orderEntity.setShopPrice(new BigDecimal(1));
        if (userService.addUser(userEntity, orderEntity)) {
            return "add info success";
        }
        return "add info fail";
    }


    @GetMapping("test2")
    public String testFail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("root");
        userEntity.setBalance(new BigDecimal(250));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPayStatus(0);
        orderEntity.setShopName("Iphone 200");
        orderEntity.setShopPrice(new BigDecimal(250));
        if (userService.addUser(userEntity, orderEntity)) {
            return "add info success";
        }
        return "add info fail";
    }

    @GetMapping("user")
    public List<UserEntity> helloWord(){
        List<UserEntity> list = userService.allUser();
        return list;
    }
    @GetMapping("order")
    public List<OrderEntity> order(){
        List<OrderEntity> list = orderService.allOrder();
        return list;
    }
}
