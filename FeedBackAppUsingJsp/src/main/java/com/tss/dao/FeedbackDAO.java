package com.tss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tss.model.Feedback;

public class FeedbackDAO {
    public void saveFeedback(Feedback fb) throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback", "root", "Dhyey1212");
        String sql = "INSERT INTO feedback (name, session_date, session_content, query_feedback, interactivity, impactful_learning, delivery_skills) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, fb.getName());
        ps.setString(2, fb.getSessionDate());
        ps.setInt(3, fb.getSessionContent());
        ps.setInt(4, fb.getQueryFeedback());
        ps.setInt(5, fb.getInteractivity());
        ps.setInt(6, fb.getImpactfulLearning());
        ps.setInt(7, fb.getDeliverySkills());
        ps.executeUpdate();
        conn.close();
    }

}
