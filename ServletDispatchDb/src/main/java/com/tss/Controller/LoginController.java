package com.tss.Controller;

import com.tss.model.*;
import com.tss.Service.*;
import com.util.DBUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String theme = request.getParameter("theme");

        UserService service = new UserService(DBUtil.getConnection());
        UserModel user = service.authenticate(username, password, role);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (user != null) {
            request.setAttribute("user", user);
            request.setAttribute("theme", theme);

            RequestDispatcher dispatcher;
            if (role.equalsIgnoreCase("Admin")) {
                dispatcher = request.getRequestDispatcher("adminController");
            } else {
                dispatcher = request.getRequestDispatcher("customerController");
            }
            dispatcher.forward(request, response);
        } else {
            out.println("<h3 style='color:red'>Invalid credentials or role mismatch</h3>");
        }
    }
}
