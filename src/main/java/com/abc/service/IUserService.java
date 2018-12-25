package com.abc.service;

import com.abc.annotation.ArgsVerify;
import com.abc.domain.User;
import org.aspectj.lang.annotation.Around;

import java.util.List;

/**
 * Created by Reen on 2018/12/16.
 */
public interface IUserService {
    /**
     *测试方法
     * @param
     * @return 所有用户
     */
    List<User> allUser();

    /**
     * 注解测试
     * @param user
     */
    void userTest(User user);
}
