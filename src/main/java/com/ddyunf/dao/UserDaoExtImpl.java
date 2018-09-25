package com.ddyunf.dao;

import com.ddyunf.BaseJpaDaoSupport;
import com.ddyunf.po.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2017/6/7.
 */
public class UserDaoExtImpl extends BaseJpaDaoSupport<User, Long>
        implements UserDaoExt {

    @PersistenceContext
    private EntityManager entityManager;


    public User queryUserCensus(User queryVO) {

        return null;
    }
}
