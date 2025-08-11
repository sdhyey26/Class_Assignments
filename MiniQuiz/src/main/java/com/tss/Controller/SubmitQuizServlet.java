package com.tss.Controller;

import com.tss.DAO.QuestionDAO;
import com.tss.DAO.ResultDAO;
import com.tss.model.Question;
import com.tss.model.Result;
import com.tss.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/SubmitQuizServlet")
public class SubmitQuizServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        @SuppressWarnings("unchecked")
        Map<Integer, String> userAnswers = (Map<Integer, String>) session.getAttribute("answers");
        User user = (User) session.getAttribute("user");

        QuestionDAO dao = new QuestionDAO();
        List<Question> questions = dao.getAllQuestions();

        int score = 0;
        for (Question q : questions) {
            String userAnswer = userAnswers.getOrDefault(q.getId(), "");
            if (q.getCorrect().equalsIgnoreCase(userAnswer)) {
                score++;
            }
        }

        Result result = new Result();
        result.setUserId(user.getId());
        result.setScore(score);
        new ResultDAO().saveResult(result);

        session.invalidate();

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Quiz Result</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #43cea2, #185a9d); height: 100vh; display: flex; align-items: center; justify-content: center; margin: 0; }");
        response.getWriter().println(".container { background-color: #fff; padding: 30px 50px; border-radius: 10px; box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3); text-align: center; }");
        response.getWriter().println("h2 { color: #333; font-size: 28px; margin-bottom: 20px; }");
        response.getWriter().println("p { font-size: 18px; margin-bottom: 30px; }");
        response.getWriter().println("strong { font-size: 22px; color: #185a9d; }");
        response.getWriter().println("a { text-decoration: none; color: white; background-color: #185a9d; padding: 10px 20px; border-radius: 5px; }");
        response.getWriter().println("a:hover { background-color: #143f6b; }");
        response.getWriter().println("</style></head><body>");
        response.getWriter().println("<div class='container'>");
        response.getWriter().println("<h2>Quiz Completed!</h2>");
        response.getWriter().println("<p>Your Score: <strong>" + score + "</strong> out of " + questions.size() + "</p>");
        response.getWriter().println("<a href='login.html'>Login Again</a>");
        response.getWriter().println("</div></body></html>");
    }
}
