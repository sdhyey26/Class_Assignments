package com.tss.Controller;

import com.tss.model.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/customerController")
public class CustomerController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        UserModel user = (UserModel) request.getAttribute("user");
        String theme = (String) request.getAttribute("theme");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body style='background-color:" + theme + "'>");
        out.println("<h1>Welcome " + user.getUsername() + "!</h1>");
        out.println("<h2>Your Role: Customer</h2>");
        out.println("</body>");
    }
}
