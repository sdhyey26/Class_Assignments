package com.tss.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/choiceController")
public class ChoiceController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userType = request.getParameter("userTypeText");
        String name = request.getParameter("nameText");

        request.setAttribute("name", name);
        RequestDispatcher dispatcher = null;

        if (userType.equalsIgnoreCase("Customer")) {
            dispatcher = request.getRequestDispatcher("customerController");
        } else if (userType.equalsIgnoreCase("Admin")) {
            dispatcher = request.getRequestDispatcher("adminController");
        }

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
