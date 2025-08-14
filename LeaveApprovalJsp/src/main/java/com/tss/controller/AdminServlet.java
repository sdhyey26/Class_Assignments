package com.tss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.User;
import com.tss.service.LeaveService;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LeaveService service = new LeaveService(); 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getParameter("action");
        int requestId = Integer.parseInt(req.getParameter("request_id"));
        int userId = Integer.parseInt(req.getParameter("user_id"));
        
        try {
            if ("approve".equals(action)) {
                service.approveLeave(requestId, userId); 
            } else if ("reject".equals(action)) {
                String reason = req.getParameter("rejection_reason");
                if (reason == null || reason.trim().isEmpty()) {
                    res.sendRedirect("adminDashboard.jsp?error=Rejection reason is required");
                    return;
                }
                service.rejectLeave(requestId, reason);
            }
            res.sendRedirect("adminDashboard.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
