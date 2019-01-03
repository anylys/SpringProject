package com.anyly.service.user;
import com.anyly.service.user.bo.UserBO;

import java.util.List;
/**
 * @author lishengrong
 */
public interface UserService {
    List<UserBO> userInfo(Integer userId);

    /**
     * 扣除用户余额
     * @return
     */
    Boolean reduceMoney(UserBO userBO);

}