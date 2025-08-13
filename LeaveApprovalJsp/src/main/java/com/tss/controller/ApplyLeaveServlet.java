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
		Date start = Date.valueOf(req.getParameter("start_date"));
		Date end = Date.valueOf(req.getParameter("end_date"));
		String reason = req.getParameter("reason");

		LocalDate startDate = start.toLocalDate();
		LocalDate endDate = end.toLocalDate();
		long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;

		if (user.getLeaveBalance() < days) {
			res.sendRedirect("applyLeave.jsp?error=Insufficient leave balance.");
			return;
		}

		LeaveRequest lr = new LeaveRequest();
		lr.setUserId(user.getId());
		lr.setStartDate(start);
		lr.setEndDate(end);
		lr.setReason(reason);

		LeaveService service = new LeaveService();
		try {
			service.applyLeave(lr);
			res.sendRedirect("employeeDashboard.jsp?msg=Leave applied");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
