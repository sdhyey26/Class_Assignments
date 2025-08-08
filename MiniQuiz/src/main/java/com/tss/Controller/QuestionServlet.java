package com.tss.Controller;

import com.tss.DAO.QuestionDAO;
import com.tss.model.Question;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        @SuppressWarnings("unchecked")
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
        int current = Integer.parseInt(request.getParameter("q") != null ? request.getParameter("q") : "1");

        QuestionDAO dao = new QuestionDAO();
        List<Question> allQuestions = dao.getAllQuestions();

        if (current > allQuestions.size()) {
            response.sendRedirect("SubmitQuizServlet");
            return;
        }

        Question q = allQuestions.get(current - 1);

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Question " + current + "</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background: linear-gradient(to right, #6a11cb, #2575fc); margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center; }");
        response.getWriter().println(".container { background-color: #fff; padding: 30px 40px; border-radius: 10px; box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3); width: 450px; }");
        response.getWriter().println("h2 { text-align: center; color: #333; margin-bottom: 25px; }");
        response.getWriter().println("form p { font-size: 18px; font-weight: bold; margin-bottom: 15px; }");
        response.getWriter().println("label { display: block; margin: 12px 0; font-size: 16px; cursor: pointer; }");
        response.getWriter().println("input[type='radio'] { margin-right: 10px; }");
        response.getWriter().println("button { width: 100%; padding: 12px; margin-top: 20px; font-size: 16px; background-color: #2575fc; color: white; border: none; border-radius: 5px; cursor: pointer; }");
        response.getWriter().println("button:hover { background-color: #1a5ed9; }");
        response.getWriter().println("</style></head><body>");

        response.getWriter().println("<div class='container'>");
        response.getWriter().println("<h2>Question " + current + " of " + allQuestions.size() + "</h2>");
        response.getWriter().println("<form method='post' action='QuestionServlet'>");
        response.getWriter().println("<p>" + q.getText() + "</p>");
        response.getWriter().println("<input type='hidden' name='qno' value='" + q.getId() + "'>");
        response.getWriter().println("<label><input type='radio' name='answer' value='A' required> " + q.getOptionA() + "</label>");
        response.getWriter().println("<label><input type='radio' name='answer' value='B'> " + q.getOptionB() + "</label>");
        response.getWriter().println("<label><input type='radio' name='answer' value='C'> " + q.getOptionC() + "</label>");
        response.getWriter().println("<label><input type='radio' name='answer' value='D'> " + q.getOptionD() + "</label>");
        response.getWriter().println("<button type='submit'>Next</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</div></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        int qno = Integer.parseInt(request.getParameter("qno"));
        String selected = request.getParameter("answer");

        @SuppressWarnings("unchecked")
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");

        answers.put(qno, selected);
        response.sendRedirect("QuestionServlet?q=" + (qno + 1));
    }
}
