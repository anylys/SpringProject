package com.anyly.service.impl;

import com.anyly.order.mapper.OrderMapper;
import com.anyly.order.model.OrderEntity;
import com.anyly.service.UserService;

import com.anyly.user.mapper.UserMapper;
import com.anyly.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * @author
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<UserEntity> allUser(){
        return userMapper.allUser();
    }

    @Override
    @Transactional
    public boolean addUser(UserEntity userEntity, OrderEntity orderEntity) {
      Long userId =  userMapper.addUser(userEntity);
       if( userId!=null){
           orderEntity.setUserId(userId);
           if(orderMapper.addOrder(orderEntity)>0){
               if(userEntity.getName().equals("root")){
                   throw new RuntimeException("Users cannot be root ! ");
               }
               return true;
           }
           throw new RuntimeException("保存数据库失败！");
       }
        throw new RuntimeException("用户信息保存数据库失败！");
    }
}
