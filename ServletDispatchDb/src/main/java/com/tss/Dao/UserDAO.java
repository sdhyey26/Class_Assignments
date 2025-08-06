package com.tss.Dao;

import com.tss.model.UserModel;
import java.sql.*;

public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public UserModel validateUser(String username, String password, String role) {
        UserModel user = null;
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setTheme(rs.getString("theme"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
