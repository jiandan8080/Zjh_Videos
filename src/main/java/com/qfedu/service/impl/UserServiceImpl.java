package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {

        User user = userDao.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("账号错误");
        }
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void add(String email, String password, String pswagain) {

        if (email == null) {
            throw new RuntimeException("请输入邮箱");
        }

        User u1 = userDao.findByEmail(email);
        if (u1 != null) {
            throw new RuntimeException("该用户已存在");
        }

        if (password == null) {
            throw new RuntimeException("请输入密码");
        }

        if (pswagain == null) {
            throw new RuntimeException("请再次输入密码");
        }

        if (!password.equals(pswagain)) {
            throw new RuntimeException("两次输入密码不一致");
        }

        User u2 = new User();

        u2.setEmail(email);
        u2.setPassword(password);
        userDao.add(u2);
        System.out.println("ok");
    }

    @Override
    public User findByEmail(String email) {
        User user = userDao.findByEmail(email);
        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
