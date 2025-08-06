package com.tss.service;

import java.util.List;

import com.tss.Dao.UserDao;
import com.tss.model.UserModel;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean registerUser(UserModel user) {
        if (user == null || user.getUserName() == null || user.getPassword() == null) {
            return false;
        }
        return userDao.saveUser(user.getUserName(), user.getPassword());
    }

    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }
}
