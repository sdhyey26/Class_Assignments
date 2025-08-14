package com.tss.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.tss.DAO.LeaveDAO;
import com.tss.model.LeaveRequest;

public class LeaveService {
    LeaveDAO dao = new LeaveDAO();

    public void applyLeave(LeaveRequest req) throws Exception {
        dao.applyLeave(req);
    }

    public List<LeaveRequest> getAllRequests() throws Exception {
        return dao.getAllRequests();
    }

    public List<LeaveRequest> getFilteredRequests(String status, String from, String to) throws Exception {
        return dao.getFilteredRequests(status, from, to);
    }

    public void approveLeave(int requestId, int userId) throws Exception {
        LeaveRequest request = dao.getLeaveRequestById(requestId);
        if (request != null) {
            LocalDate start = request.getStartDate().toLocalDate();
            LocalDate end = request.getEndDate().toLocalDate();
            long days = ChronoUnit.DAYS.between(start, end) + 1;

            dao.updateLeaveStatus(requestId, "APPROVED");
            dao.updateLeaveBalance(userId, (int) days);
        }
    }

    public void rejectLeave(int requestId, String reason) throws Exception {
        dao.rejectLeaveWithReason(requestId, reason); // updates both status and reason
    }

    public boolean canApplyForLeave(int userId) throws Exception {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        int requestCount = LeaveDAO.countMonthlyLeaveRequests(userId, currentMonth, currentYear);
        return requestCount < 3;
    }

    // ✅ New method to check for overlapping requests
    public boolean hasOverlappingLeave(int userId, Date start, Date end) throws Exception {
        return dao.isOverlappingLeave(userId, start, end);
    }
}
