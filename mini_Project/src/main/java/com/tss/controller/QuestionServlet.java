package com.tss.controller;

import com.tss.dao.QuestionDAO;
import com.tss.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Question> questions = QuestionDAO.getAllQuestions();
        Integer questionIndex = (Integer) session.getAttribute("questionIndex");

        if (questionIndex >= questions.size()) {
            response.sendRedirect("ResultServlet");
            return;
        }

        Question currentQuestion = questions.get(questionIndex);
        request.setAttribute("question", currentQuestion);
        request.getRequestDispatcher("question.html").forward(request, response);
    }
}
