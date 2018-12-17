package com.abc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类 通用
 * Created by Reen on 2018/12/16.
 * @author Reen
 */
@Data
public class BaseDomain implements Serializable{

    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

}
