package com.anyly.user.mapper;

import com.anyly.user.model.UserEntity;

import java.util.List;

/**
 * @author lishengrong
 */
public interface UserMapper {
    List<UserEntity> allUser();
    Long addUser(UserEntity userEntity);
}
