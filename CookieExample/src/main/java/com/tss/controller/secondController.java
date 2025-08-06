package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class secondController
 */
@WebServlet("/secondController")
public class secondController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public secondController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		// Get last name from form
		String lastName = request.getParameter("lastNameTxt");

		// Retrieve session and get first name
		HttpSession session = request.getSession(false);
		String firstName = null;

		if (session != null) {
			firstName = (String) session.getAttribute("firstName");
		}

		writer.print("<html><body>");
		if (firstName != null && lastName != null) {
			writer.print("First Name: " + firstName + "<br>");
			writer.print("Last Name: " + lastName);
		} else {
			writer.print("Session expired or missing data.");
		}
		writer.print("</body></html>");

		writer.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
