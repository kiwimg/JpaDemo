package com.ddyunf.mm.service;
import com.ddyunf.dao.UserDao;
import com.ddyunf.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/7.
 */
@Service("UserService2")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public User findUserByAllId(long uid) {
       return userDao.findUserByAllId(uid);
    }

}
