package com.abc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 * Created by Reen on 2018/12/16.
 *@author Reen
 */
@Data
public class User extends BaseDomain implements Serializable{

    private String userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userGroup;
    private String userDepartment;
    private String userUUID;


}
