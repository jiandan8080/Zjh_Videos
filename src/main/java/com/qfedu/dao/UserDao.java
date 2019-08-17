package com.qfedu.dao;

import com.qfedu.entity.User;

public interface UserDao {

    public User findByEmail(String email);

    public void add(User user);

    public void update(User user);

}
