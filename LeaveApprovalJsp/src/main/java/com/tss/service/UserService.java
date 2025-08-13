package com.tss.service;


import com.tss.DAO.UserDAO;
import com.tss.model.User;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User login(String username, String password) throws Exception {
        return userDAO.login(username, password);
    }
    
    public boolean registerUser(User user) throws Exception {
        if (userDAO.findUserByUsername(user.getUsername()) != null) {
            return false;
        }

        return userDAO.saveUser(user);
    }
    
    public User validateUser(String username, String password) throws Exception {
        return userDAO.validateUser(username, password);
    }

    public int getLeaveBalance(int userId) throws Exception {
        return userDAO.getLeaveBalance(userId);
    }
}

