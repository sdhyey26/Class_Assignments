package com.tss.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.LeaveRequest;

public class LeaveDAO {

    public void applyLeave(LeaveRequest lr) throws SQLException {
        String sql = "INSERT INTO leave_requests (user_id, start_date, end_date, reason) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, lr.getUserId());
            stmt.setDate(2, new java.sql.Date(lr.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(lr.getEndDate().getTime()));
            stmt.setString(4, lr.getReason());
            stmt.executeUpdate();
        }
    }

    public List<LeaveRequest> getAllRequests() throws SQLException {
        List<LeaveRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM leave_requests";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LeaveRequest lr = new LeaveRequest();
                lr.setId(rs.getInt("id"));
                lr.setUserId(rs.getInt("user_id"));
                lr.setStartDate(rs.getDate("start_date"));
                lr.setEndDate(rs.getDate("end_date"));
                lr.setReason(rs.getString("reason"));
                lr.setStatus(rs.getString("status"));
                list.add(lr);
            }
        }
        return list;
    }

    public void updateLeaveStatus(int id, String status) throws SQLException {
        String sql = "UPDATE leave_requests SET status=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void updateLeaveBalance(int userId, int days) throws SQLException {
        String sql = "UPDATE users SET leave_balance = leave_balance - ? WHERE id = ? AND leave_balance >= ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, days);
            stmt.setInt(2, userId);
            stmt.setInt(3, days);
            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new SQLException("Insufficient leave balance.");
            }
        }
    }

    
    public LeaveRequest getLeaveRequestById(int requestId) throws SQLException {
        String sql = "SELECT * FROM leave_requests WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, requestId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    LeaveRequest lr = new LeaveRequest();
                    lr.setId(rs.getInt("id"));
                    lr.setUserId(rs.getInt("user_id"));
                    lr.setStartDate(rs.getDate("start_date"));
                    lr.setEndDate(rs.getDate("end_date"));
                    lr.setReason(rs.getString("reason"));
                    lr.setStatus(rs.getString("status"));
                    return lr;
                }
            }
        }
        return null;
    }
    
    public int getLeaveBalance(int userId) throws SQLException {
        String sql = "SELECT leave_balance FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("leave_balance");
                }
            }
        }
        return 0;
    }
}
