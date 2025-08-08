package com.tss.controller;

import com.tss.dao.QuestionDAO;
import com.tss.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SubmitAnswerServlet")
public class SubmitAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String selectedOption = request.getParameter("option");
        Integer score = (Integer) session.getAttribute("score");
        Integer questionIndex = (Integer) session.getAttribute("questionIndex");

        List<Question> questions = QuestionDAO.getAllQuestions();
        Question currentQuestion = questions.get(questionIndex);

        if (selectedOption != null && selectedOption.charAt(0) == currentQuestion.getCorrectOption()) {
            score++;
        }

        session.setAttribute("score", score);
        session.setAttribute("questionIndex", questionIndex + 1);

        response.sendRedirect("QuestionServlet");
    }
}
