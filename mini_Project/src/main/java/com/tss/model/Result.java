package com.tss.model;

import java.sql.Timestamp;

public class Result {
    private int id;
    private int userId;
    private int score;
    private Timestamp takenAt;

    public Result() {}

    public Result(int id, int userId, int score, Timestamp takenAt) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.takenAt = takenAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Timestamp takenAt) {
        this.takenAt = takenAt;
    }
}
