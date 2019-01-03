package com.anyly.controller;
import com.anyly.service.UserService;
import com.anyly.user.model.UserEntity;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lishengrong
 */
@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @GetMapping("info")
    public List<UserEntity> allOrder(){
        List<UserEntity> list = userService.allUser();
        logger.info(list.size());
        return list;
    }
}
