package com.tss.Service;

import java.sql.Connection;

import com.tss.Dao.UserDAO;
import com.tss.model.UserModel;

public class UserService {
    private UserDAO userDao;

    public UserService(Connection conn) {
        this.userDao = new UserDAO(conn);
    }

    public UserModel authenticate(String username, String password, String role) {
        return userDao.validateUser(username, password, role);
    }
}
