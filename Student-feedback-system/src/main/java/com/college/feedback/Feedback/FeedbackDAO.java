package com.college.feedback.Feedback;


import java.sql.*;
import java.util.*;

public class FeedbackDAO {

    public void createFeedback(Feedback fb) throws SQLException {
        String sql = "INSERT INTO feedback (id, student_name, feedback_text) VALUES (?, ?, ?)";
        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, fb.getId());
            ps.setString(2, fb.getStudentName());
            ps.setString(3, fb.getFeedback());
            ps.executeUpdate();
        }
    }

    public Feedback getFeedbackById(int id) throws SQLException {
        String sql = "SELECT * FROM feedback WHERE id = ?";
        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Feedback fb = new Feedback();
                fb.setId(rs.getInt("id"));
                fb.setStudentName(rs.getString("student_name"));
                fb.setFeedback(rs.getString("feedback_text"));
                return fb;
            }
            return null;
        }
    }

    public List<Feedback> getAllFeedback() throws SQLException {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        try (Connection con = DBConnectionPool.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setId(rs.getInt("id"));
                fb.setStudentName(rs.getString("student_name"));
                fb.setFeedback(rs.getString("feedback_text"));
                list.add(fb);
            }
        }
        return list;
    }

    public boolean updateFeedback(Feedback fb) throws SQLException {
        String sql = "UPDATE feedback SET student_name = ?, feedback_text = ? WHERE id = ?";
        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fb.getStudentName());
            ps.setString(2, fb.getFeedback());
            ps.setInt(3, fb.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteFeedback(int id) throws SQLException {
        String sql = "DELETE FROM feedback WHERE id = ?";
        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
