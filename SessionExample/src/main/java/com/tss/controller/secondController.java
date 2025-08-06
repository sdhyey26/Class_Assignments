package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondController")
public class secondController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public secondController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		
		String lastName = request.getParameter("lastNameTxt");

		
		HttpSession session = request.getSession(false);

		if (session != null) {
			
			String firstName = (String) session.getAttribute("firstName");

			
			session.setAttribute("lastName", lastName);

			writer.print("<html><body>");
			writer.print("<h3>Full Name:</h3>");
			writer.print("First Name: " + firstName + "<br>");
			writer.print("Last Name: " + lastName);
			writer.print("</body></html>");
		} else {
			writer.print("Session has expired. Please start over.");
		}

		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
