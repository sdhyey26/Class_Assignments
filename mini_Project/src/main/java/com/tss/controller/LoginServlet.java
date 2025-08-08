package com.tss.controller;

import com.tss.dao.UserDAO;
import com.tss.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserDAO.validateUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("score", 0);
            session.setAttribute("questionIndex", 0);
            response.sendRedirect("question.html");
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}
