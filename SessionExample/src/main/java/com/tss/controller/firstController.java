package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firstController")
public class firstController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public firstController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String firstName = request.getParameter("firstName");

		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);

		writer.print("<html><body>");
		writer.print("<form action='secondController' method='post'>");
		writer.print("Last Name: <input type='text' name='lastNameTxt'><br><br>");
		writer.print("<button type='submit'>Next</button>");
		writer.print("</form>");
		writer.print("</body></html>");

		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
