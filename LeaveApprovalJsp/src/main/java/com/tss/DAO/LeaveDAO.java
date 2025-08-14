package com.tss.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.LeaveRequest;

public class LeaveDAO {

	private LeaveRequest extractRequest(ResultSet rs) throws SQLException {
	    LeaveRequest req = new LeaveRequest();
	    req.setId(rs.getInt("id"));
	    req.setUserId(rs.getInt("user_id"));
	    req.setStartDate(rs.getDate("start_date"));
	    req.setEndDate(rs.getDate("end_date"));
	    req.setReason(rs.getString("reason"));
	    req.setStatus(rs.getString("status"));

	    try {
	        req.setRejectionReason(rs.getString("rejection_reason"));
	    } catch (SQLException ignored) {}

	    try {
	        java.sql.Date decisionDate = rs.getDate("decision_date");
	        if (decisionDate != null) {
	            req.setDecisionDate(decisionDate.toLocalDate());
	        }
	    } catch (SQLException ignored) {}

	    return req;
	}
	
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
        String sql = "SELECT * FROM leave_requests ORDER BY start_date DESC";
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
                lr.setRejectionReason(rs.getString("rejection_reason"));
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
    
    public void rejectLeaveWithReason(int requestId, String reason) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE leave_requests SET status = 'REJECTED', rejection_reason = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, reason);
        ps.setInt(2, requestId);
        ps.executeUpdate();
        ps.close();
        con.close();
    }



    public List<LeaveRequest> getFilteredRequests(String status, String startDate, String endDate) throws Exception {
        Connection conn = DBConnection.getConnection();
        StringBuilder query = new StringBuilder("SELECT * FROM leave_requests WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (status != null && !status.trim().equalsIgnoreCase("ALL") && !status.trim().isEmpty()) {
            query.append(" AND status = ?");
            params.add(status.trim().toUpperCase());
        }

        java.sql.Date fromDate = null;
        java.sql.Date toDate = null;

        if (startDate != null && !startDate.trim().isEmpty()) {
            fromDate = java.sql.Date.valueOf(startDate.trim());
        }
        if (endDate != null && !endDate.trim().isEmpty()) {
            toDate = java.sql.Date.valueOf(endDate.trim());
        }

        if (fromDate != null && toDate != null) {
            query.append(" AND start_date BETWEEN ? AND ?");
            params.add(fromDate);
            params.add(toDate);
        } else if (fromDate != null) {
            query.append(" AND start_date >= ?");
            params.add(fromDate);
        } else if (toDate != null) {
            query.append(" AND start_date <= ?");
            params.add(toDate);
        }

        PreparedStatement ps = conn.prepareStatement(query.toString());
        for (int i = 0; i < params.size(); i++) {
            Object param = params.get(i);
            if (param instanceof String) {
                ps.setString(i + 1, (String) param);
            } else if (param instanceof java.sql.Date) {
                ps.setDate(i + 1, (java.sql.Date) param);
            }
        }

        ResultSet rs = ps.executeQuery();
        List<LeaveRequest> list = new ArrayList<>();
        while (rs.next()) {
            LeaveRequest req = extractRequest(rs);
            list.add(req);
        }

        rs.close();
        ps.close();
        conn.close();

        return list;
    }




    
    public void updateUserLeaveBalance(int userId, int requestId) throws Exception {
        Connection con = DBConnection.getConnection();

        String leaveQuery = "SELECT start_date, end_date FROM leave_requests WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(leaveQuery);
        ps.setInt(1, requestId);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            throw new Exception("Leave request not found");
        }

        LocalDate start = rs.getDate("start_date").toLocalDate();
        LocalDate end = rs.getDate("end_date").toLocalDate();
        long days = ChronoUnit.DAYS.between(start, end) + 1;

        rs.close();
        ps.close();

        String updateQuery = "UPDATE users SET leave_balance = leave_balance - ? WHERE id = ?";
        ps = con.prepareStatement(updateQuery);
        ps.setInt(1, (int) days);
        ps.setInt(2, userId);
        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public void logAdminAction(int adminId, String action, int requestId, String reason) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO admin_logs (admin_id, action_type, request_id, reason) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, adminId);
        ps.setString(2, action);
        ps.setInt(3, requestId);
        ps.setString(4, reason != null ? reason : "");

        ps.executeUpdate();
        ps.close();
        con.close();
    }
    
    public static int countMonthlyLeaveRequests(int userId, int month, int year) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT COUNT(*) FROM leave_requests WHERE user_id = ? AND MONTH(start_date) = ? AND YEAR(start_date) = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ps.setInt(2, month);
        ps.setInt(3, year);
        
        ResultSet rs = ps.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        conn.close();
        return count;
    }
    

 public boolean isOverlappingLeave(int userId, Date start, Date end) throws Exception {
     String query = "SELECT COUNT(*) FROM leave_requests " +
                    "WHERE user_id = ? AND status IN ('PENDING', 'APPROVED') " +
                    "AND (start_date <= ? AND end_date >= ?)";

     try (Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement(query)) {

         ps.setInt(1, userId);
         ps.setDate(2, end);   
         ps.setDate(3, start);
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
             int count = rs.getInt(1);
             return count > 0;
         }
     }
     return false;
 }

}
