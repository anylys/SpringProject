package com.anyly.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.anyly.mapper.UserMapper;
import com.anyly.model.UserDO;
import com.anyly.service.user.UserService;
import com.anyly.service.user.bo.UserBO;
import com.anyly.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author anyly
 * 接口实现
 */
@Component
@Service(timeout = 5000)
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserBO> userInfo(Integer userId) {
        List<UserDO> list = userMapper.select(userId);
        return BeanCopyUtil.listCopy(list, UserBO.class);
    }
    @Transactional
    @Override
    public Boolean reduceMoney( UserBO userBO) {
        UserDO userDO =BeanCopyUtil.beanCopy(userBO,UserDO.class);
        if(userBO.getBalance().compareTo(BigDecimal.ZERO)>=0){
            Integer r = userMapper.updateUserMoney(userDO);
            if(r>0){
                return true;
            }
            throw new RuntimeException("扣除用户余额失败！");
        }else{
            throw new RuntimeException("余额不足！");
        }
    }
}