package com.ddyunf.dd.service;

import com.ddyunf.po.User;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface UserService {

    User findUserByAllId(long uid);
    User findUserById(long uid);
}
