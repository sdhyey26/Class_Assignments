package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.UserModel;
import com.tss.service.UserService;

@WebServlet("/userController")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String action = request.getParameter("action");

		if (action == null) {
			writer.println("<h3 style='color:orange;'>No action provided.</h3>");
			return;
		}

		if ("login".equalsIgnoreCase(action)) {
			String username = request.getParameter("usernameTxt");
			String password = request.getParameter("passwordTxt");

			if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
				writer.println("<h3 style='color:red;'>Username and Password are required.</h3>");
				return;
			}

			UserModel user = new UserModel(username, password);
			boolean result = service.registerUser(user);

			if (result) {
				writer.println("<h3 style='color:green;'>User logged in and saved successfully!</h3>");
			} else {
				writer.println("<h3 style='color:red;'>Failed to save user.</h3>");
			}

		} else if ("viewAll".equalsIgnoreCase(action)) {
			List<UserModel> users = service.getAllUsers();

			writer.println("<h3>All Registered Users:</h3>");
			if (!users.isEmpty()) {
				for (UserModel u : users) {
					writer.println("Username: " + u.getUserName() + ", Password: " + u.getPassword() + "<br>");
				}
			} else {
				writer.println("<h4 style='color:red;'>No users found.</h4>");
			}

		} else {
			writer.println("<h3 style='color:red;'>Invalid action.</h3>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
