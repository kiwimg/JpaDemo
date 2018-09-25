package com.ddyunf.dao;

import com.ddyunf.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface UserDao extends JpaRepository<User, Long>, UserDaoExt {

    public static final String ddd="";
    /**
     * 原生sql
     * @param uid
     * @return
     */
//    @Query(value = "SELECT * FROM users  WHERE uid = ?1",nativeQuery = true)
    User findUserByAllId(Long uid);


    /**
     * jpq
     * @param uid
     * @return
     */
    //@Query("FROM User  WHERE uid = ?1")
    User findUserById(Long uid);

    /**
     * 使用@Param注解注入参数
     * @param name
     * @return
     */
    @Query(value = "FROM User b where b.name = :name")
    List<User> findByNamedParam(@Param("name") String name);
}
