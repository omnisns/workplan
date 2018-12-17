package com.abc.dao;

import com.abc.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Reen on 2018/12/16.
 * @author Reen
 */
@Mapper
public interface UserDAO {
    /**
     * 查找所有用户
     * @param
     * @return 所有用户
     */
    List<User> findAllUser();

}
