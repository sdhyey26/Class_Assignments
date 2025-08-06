package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("nameTxt");
        String address = request.getParameter("addressTxt");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String[] languages = request.getParameterValues("languages");
        String username = request.getParameter("usernameTxt");
        String password = request.getParameter("passwordTxt");
        String confirmPassword = request.getParameter("confirmPwdTxt");

        if(password.equals(confirmPassword) && !password.isEmpty()) {
        	writer.println("<html><body>");
            writer.println("<h2>Registration Details</h2>");
            writer.println("Name: " + name + "<br>");
            writer.println("Address: " + address + "<br>");
            writer.println("Gender: " + gender + "<br>");
            writer.println("City: " + city + "<br>");

            writer.println("Languages Known: ");
            if (languages != null) {
                for (String lang : languages) {
                    writer.print(lang + " ");
                }
            } else {
                writer.print("None");
            }
            writer.println("<br>");

            writer.println("Username: " + username + "<br>");
            

            writer.println("</body></html>");
        }
        else {
        	writer.print("Unable to fetch");
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
