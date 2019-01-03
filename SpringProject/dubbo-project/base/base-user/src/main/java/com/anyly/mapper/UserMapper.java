package com.anyly.mapper;

import com.anyly.model.UserDO;

import java.util.List;

/**
 * mapper 接口
 */
public interface UserMapper {

    void insert(UserDO user);
    List<UserDO> select(Integer id);

    Integer updateUserMoney(UserDO userDO);
}
