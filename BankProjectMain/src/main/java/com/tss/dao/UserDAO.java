package com.tss.dao;

import com.tss.model.User;
import com.tss.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	public static boolean createUserAndAccount(User user) {
	    try (Connection con = DBConnection.getConnection()) {

	        String checkQuery = "SELECT a.account_type FROM users u " +
	                            "JOIN accounts a ON u.user_id = a.user_id " +
	                            "WHERE a.aadhar = ? AND a.account_type = ?";
	        PreparedStatement check = con.prepareStatement(checkQuery);
	        check.setString(1, user.getAadhar());
	        check.setString(2, user.getAccountType());

	        ResultSet rs = check.executeQuery();
	        if (rs.next()) {
	            return false;
	        }

	        String userCheckQuery = "SELECT user_id FROM users WHERE username = ?";
	        PreparedStatement userCheck = con.prepareStatement(userCheckQuery);
	        userCheck.setString(1, user.getUsername());
	        ResultSet userRs = userCheck.executeQuery();

	        int userId;
	        if (userRs.next()) {
	            userId = userRs.getInt("user_id");
	        } else {
	            String insertUser = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
	            PreparedStatement ps1 = con.prepareStatement(insertUser, PreparedStatement.RETURN_GENERATED_KEYS);
	            ps1.setString(1, user.getUsername());
	            ps1.setString(2, user.getPassword());
	            ps1.setString(3, "Customer");
	            ps1.executeUpdate();

	            ResultSet keys = ps1.getGeneratedKeys();
	            if (keys.next()) {
	                userId = keys.getInt(1);
	            } else {
	                return false;
	            }
	        }

	        String accountNumber = "100" + (int)(Math.random() * 1000000);

	        String insertAccount = "INSERT INTO accounts (user_id, account_number, name, mobile, email, aadhar, account_type, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps2 = con.prepareStatement(insertAccount);
	        ps2.setInt(1, userId);
	        ps2.setString(2, accountNumber);
	        ps2.setString(3, user.getName());
	        ps2.setString(4, user.getMobile());
	        ps2.setString(5, user.getEmail());
	        ps2.setString(6, user.getAadhar());
	        ps2.setString(7, user.getAccountType());
	        ps2.setDouble(8, user.getInitialDeposit());
	        ps2.executeUpdate();

	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

    public static User getUserByCredentials(String username, String password, String role) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT u.*, a.name , a.email FROM users u " +
                         "LEFT JOIN accounts a ON u.user_id = a.user_id " +
                         "WHERE u.username = ? AND u.password = ? AND u.role = ? AND u.status = 'Active'";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setFullName(rs.getString("name")); 
                user.setEmail(rs.getString("email"));         
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
