package com.abc.controller;

import com.abc.domain.User;
import com.abc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Reen on 2018/12/16.
 * @author reen
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/allUser")
    public List<User> list(){
        return userService.allUser();
    }
}
