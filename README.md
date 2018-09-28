# JpaDemo
Spring-Jpa
Spring JPA 示例 ，对JPA的扩展

package com.kiwimg.po;

/**
 * Created by Administrator on 2017/6/7.
 */

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {
    private long id;
    private String name;
    private int age;
    private String sex;
    public User() {
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "uid", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long uid) {
        this.id = uid;
    }



    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        sex = sex;
    }
}
