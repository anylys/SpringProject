package com.anyly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.anyly.service.order.OrderService;
import com.anyly.service.order.bo.OrderBO;

import com.anyly.service.user.UserService;
import com.anyly.service.user.bo.UserBO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author lishengrong
 */
@RestController
@RequestMapping("index")
public class IndexController {
    @Reference
    UserService userService;

    @Reference(check = false)
    OrderService orderService;


    @RequestMapping("userInfo/{id}")
    public Object userInfo(@PathVariable Integer id){
        List<UserBO> userBOS = userService.userInfo(id);
        return userBOS;
    }

    @RequestMapping("orderList")
    public Object orderList(){
        List<OrderBO> orderBOS = orderService.allOrder();
        return orderBOS;
    }

    @RequestMapping("pay/{orderId}")
    public String pay(@PathVariable Integer orderId){
        OrderBO orderBO = orderService.getOrder(orderId);
        if(orderBO !=null ){
            if(orderService.pay(orderBO)){
                return "pay success !";
            }
            return "pay false !";
        }else{
            return "该订单不存在！";
        }
    }


}
