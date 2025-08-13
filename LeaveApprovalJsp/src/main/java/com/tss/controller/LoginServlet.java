package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.model.User;
import com.tss.service.UserService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");

	        UserService service = new UserService();
	        try {
	            User user = service.login(username, password);
	            if (user != null) {
	                HttpSession session = req.getSession();
	                session.setAttribute("user", user);
	                if (user.getRole().equals("ADMIN")) {
	                    res.sendRedirect("adminDashboard.jsp");
	                } else {
	                    res.sendRedirect("employeeDashboard.jsp");
	                }
	            } else {
	                res.sendRedirect("login.jsp?error=Invalid credentials");
	            }
	        } catch (Exception e) {
	            throw new ServletException(e);
	        }
	    }

}
