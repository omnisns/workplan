package com.abc.service.impl;

import com.abc.annotation.ArgsVerify;
import com.abc.dao.UserDAO;
import com.abc.domain.User;
import com.abc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Reen on 2018/12/16.
 */
@Service
@Transactional(rollbackFor=Exception.class,timeout=5)
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
    public List<User> allUser() {
        return userDAO.findAllUser();
    }

    @Override
    @ArgsVerify(checkClasss = User.class,propertyNames = "userId")
    public void userTest(User user) {
        System.out.println("切面完成");
    }
}
