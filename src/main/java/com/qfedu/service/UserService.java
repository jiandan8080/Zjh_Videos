package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {

    public User login(String email, String password);

    public void add(String email,String password,String pswagain);

    public User findByEmail (String email);

    public void update(User user);

}
