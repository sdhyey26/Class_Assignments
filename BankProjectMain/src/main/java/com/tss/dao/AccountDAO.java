package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.Account;
import com.tss.util.DBConnection;

public class AccountDAO {

	public static Account getAccountByUserId(int userId) {
	    Account account = null;
	    try (Connection con = DBConnection.getConnection()) {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts WHERE user_id = ?");
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            account = new Account();
	            account.setAccountNumber(rs.getString("account_number"));
	            account.setAccountType(rs.getString("account_type"));
	            account.setBalance(rs.getDouble("balance"));
	            account.setUserId(userId); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return account;
	}
	
	public static List<Account> getAccountsByUserId(int userId) {
	    List<Account> list = new ArrayList<>();
	    try (Connection con = DBConnection.getConnection()) {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM accounts WHERE user_id = ?");
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Account acc = new Account();
	            acc.setAccountNumber(rs.getString("account_number"));
	            acc.setBalance(rs.getDouble("balance"));
	            acc.setAccountType(rs.getString("account_type"));
	            acc.setUserId(rs.getInt("user_id"));
	            list.add(acc);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


}
