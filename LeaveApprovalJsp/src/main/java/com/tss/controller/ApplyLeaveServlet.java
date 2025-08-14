package com.tss.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.LeaveRequest;
import com.tss.model.User;
import com.tss.service.LeaveService;

@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApplyLeaveServlet() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        Date start = Date.valueOf(req.getParameter("start_date"));
        Date end = Date.valueOf(req.getParameter("end_date"));
        String reason = req.getParameter("reason");

        LocalDate startDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        if (days <= 0) {
            res.sendRedirect("applyLeave.jsp?error=End date must be after or equal to start date.");
            return;
        }

        if (user.getLeaveBalance() < days) {
            res.sendRedirect("applyLeave.jsp?error=Insufficient leave balance.");
            return;
        }

        LeaveService service = new LeaveService();

        try {
            boolean canApply = service.canApplyForLeave(user.getId());
            if (!canApply) {
                res.sendRedirect("applyLeave.jsp?error=You can only request leave 3 times per month.");
                return;
            }

            boolean isOverlapping = service.hasOverlappingLeave(user.getId(), start, end);
            if (isOverlapping) {
                res.sendRedirect("applyLeave.jsp?error=You already have a leave request during this period.");
                return;
            }

            LeaveRequest lr = new LeaveRequest();
            lr.setUserId(user.getId());
            lr.setStartDate(start);
            lr.setEndDate(end);
            lr.setReason(reason);

            service.applyLeave(lr);
            res.sendRedirect("employeeDashboard.jsp?msg=Leave applied successfully");

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("applyLeave.jsp?error=An error occurred while applying for leave.");
        }
    }
}
