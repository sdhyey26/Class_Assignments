package com.tss.dao;

import com.tss.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResultDAO {
    public static void saveResult(int userId, int score) {
        String sql = "INSERT INTO results (user_id, score) VALUES (?, ?)"; 

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, score);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
