package com.tss.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.DBConnection.dbConnection;
import com.tss.model.UserModel;


public class UserDao {

	Connection connection = null;

    public boolean saveUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try {
            Connection conn = dbConnection.connect(); 
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        try {
            Connection conn = dbConnection.connect();
            if (conn == null) return users;

            String query = "SELECT * FROM users";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
