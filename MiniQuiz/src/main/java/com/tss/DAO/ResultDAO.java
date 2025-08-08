package com.tss.DAO;

import java.sql.*;
import com.tss.model.Result;
import com.tss.DBConnection.DBConnection;

public class ResultDAO {

    public boolean saveResult(Result result) {
        String sql = "INSERT INTO results (user_id, score) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, result.getUserId());
            stmt.setInt(2, result.getScore());
            return stmt.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
