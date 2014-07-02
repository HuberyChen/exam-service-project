package com.exam.service;

import com.exam.dao.UserDao;
import com.exam.domain.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author hubery
 */
@Service
public class UserService {

    private UserDao userDao;

    public User get(int id) {
        return userDao.get(id);
    }

    public User get(String name) {
        return userDao.get(name);
    }

    @Inject
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
