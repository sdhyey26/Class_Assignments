package com.tss.controller;

import com.tss.dao.ResultDAO;
import com.tss.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("user");
        int score = (Integer) session.getAttribute("score");

        ResultDAO.saveResult(user.getId(), score);

        session.removeAttribute("questionIndex");
        session.removeAttribute("score");

        request.setAttribute("score", score);
        request.getRequestDispatcher("result.html").forward(request, response);
    }
}
