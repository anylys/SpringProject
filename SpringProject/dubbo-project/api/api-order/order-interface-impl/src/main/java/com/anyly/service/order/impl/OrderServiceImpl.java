package com.anyly.service.order.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.anyly.mapper.OrderMapper;
import com.anyly.model.OrderDO;
import com.anyly.service.order.OrderService;
import com.anyly.service.order.bo.OrderBO;
import com.anyly.service.user.UserService;
import com.anyly.service.user.bo.UserBO;
import com.anyly.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author lishengrong
 */
@Component
@Service(timeout = 5000)
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Reference
    UserService userService;


    @Override
    public List<OrderBO> allOrder() {
        List<OrderDO> list = orderMapper.allOrder();
        return BeanCopyUtil.listCopy(list,OrderBO.class);
    }

    @Override
    @Transactional
    public Boolean pay(OrderBO orderBO) {
        OrderDO orderDO = BeanCopyUtil.beanCopy(orderBO,OrderDO.class);
            if(orderBO !=null ){
                List<UserBO> userBOS = userService.userInfo(orderBO.getUserId());
                if(userBOS !=null && userBOS.size()>0){
                    System.out.println("调用用户服务扣钱");
                    UserBO userBO = new UserBO();
                    userBO.setId(userBOS.get(0).getId());
                    userBO.setBalance(userBOS.get(0).getBalance().subtract(orderBO.getShopPrice()));
                    System.out.println("调用订单服务更新订单状态");
                    orderBO.setPayStatus(1);
                    if(orderMapper.updateOrder(orderDO)>0){
                        if(userService.reduceMoney(userBO)){
                            return true;
                        }else{
                           throw  new RuntimeException("交易失败!扣款未成功！");
                        }
                    }
                    throw  new RuntimeException("订单交易失败，状态更新失败！");
                }else{
                    throw  new RuntimeException("订单交易失败，该用户不存在");
                }
            }
            return true;

    }

    @Override
    public OrderBO getOrder(Integer id) {
        OrderDO orderDO = orderMapper.getOrder(id);
        return BeanCopyUtil.beanCopy(orderDO,OrderBO.class);
    }
}
