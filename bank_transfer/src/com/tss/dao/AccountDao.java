package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tss.database.DBConnection;
import com.tss.dto.AccountDto;

public class AccountDao {

    public AccountDto getAccountById(int id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AccountDto(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
            }
        }
        return null;
    }

    public boolean updateBalance(int id, double newBalance) throws SQLException {
        String sql = "UPDATE accounts SET balance = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
