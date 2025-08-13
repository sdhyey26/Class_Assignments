package com.tss.service;

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

    public void approveLeave(int requestId, int userId ) throws Exception {
        LeaveRequest request = dao.getLeaveRequestById(requestId);

        LocalDate start = request.getStartDate().toLocalDate();
        LocalDate end = request.getEndDate().toLocalDate();
        long days = ChronoUnit.DAYS.between(start, end) + 1;

        dao.updateLeaveStatus(requestId, "APPROVED");
        dao.updateLeaveBalance(userId, (int) days);  
    }

    public void rejectLeave(int id) throws Exception {
        dao.updateLeaveStatus(id, "REJECTED");
    }
}
