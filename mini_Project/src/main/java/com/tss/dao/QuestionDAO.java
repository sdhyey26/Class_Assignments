package com.tss.dao;

import com.tss.model.Question;
import com.tss.util.DBConnection;

import java.sql.*;
import java.util.*;

public class QuestionDAO {
    public static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM questions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Question q = new Question(
                    rs.getInt("id"),
                    rs.getString("text"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correct").charAt(0)
                );
                questions.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Question getQuestionById(int id) {
        Question q = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM questions WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                q = new Question(
                    rs.getInt("id"),
                    rs.getString("text"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correct").charAt(0)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;
    }
}
