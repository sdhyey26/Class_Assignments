package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.model.Feedback;
import com.tss.service.FeedbackService;


@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FeedbackServlet() {
        super();
   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        HttpSession session = request.getSession();

	        Feedback fb = new Feedback();
	        fb.setName(request.getParameter("name"));
	        fb.setSessionDate(request.getParameter("sessionDate"));
	        fb.setSessionContent(Integer.parseInt(request.getParameter("sessionContent")));
	        fb.setQueryFeedback(Integer.parseInt(request.getParameter("queryFeedback")));
	        fb.setInteractivity(Integer.parseInt(request.getParameter("interactivity")));
	        fb.setImpactfulLearning(Integer.parseInt(request.getParameter("impactfulLearning")));
	        fb.setDeliverySkills(Integer.parseInt(request.getParameter("deliverySkills")));

	        try {
	            new FeedbackService().validateAndSave(fb);
	            session.setAttribute("user", fb.getName());
	            response.sendRedirect("success.jsp");
	        } catch (Exception e) {
	            session.setAttribute("error", e.getMessage());
	            response.sendRedirect("error.jsp");
	        }
	    }

}
