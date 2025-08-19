package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tss.model.Transaction;
import com.tss.util.DBConnection;

public class TransactionDAO {

	public static Transaction getLastTransaction(String accountNumber) {
	    Transaction txn = null;
	    try (Connection con = DBConnection.getConnection()) {
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT * FROM transactions WHERE from_account = ? OR to_account = ? ORDER BY timestamp DESC LIMIT 1"
	        );
	        ps.setString(1, accountNumber);
	        ps.setString(2, accountNumber);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            txn = new Transaction();
	            txn.setFromAccount(rs.getString("from_account"));
	            txn.setToAccount(rs.getString("to_account"));
	            txn.setAmount(rs.getDouble("amount"));
	            txn.setType(rs.getString("type"));
	            txn.setTimestamp(rs.getTimestamp("timestamp"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return txn;
	}


}
