package com.hx.test.java8.demo.pojo;

import java.util.Map;


public class UserDao {
    private Map<Long,User> userMap;

    public UserDao(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public User getById(Long id){
        return userMap.get(id);
    }
}
