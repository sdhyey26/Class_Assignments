package com.tss.controller;

import com.tss.dao.UserDAO;
import com.tss.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(uname);
        user.setPassword(pwd);
        user.setEmail(email);

        try {
            boolean registered = new UserDAO().registerUser(user);
            if (registered) {
                response.sendRedirect("login.html");
            } else {
                response.getWriter().println("Registration failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
