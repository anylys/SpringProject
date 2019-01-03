package com.anyly.service;



import com.anyly.order.model.OrderEntity;
import com.anyly.user.model.UserEntity;

import java.util.List;


/**
 * @author lishengrong
 */
public interface UserService {
    public List<UserEntity> allUser();
    public boolean addUser(UserEntity userEntity, OrderEntity orderEntity) ;
}
