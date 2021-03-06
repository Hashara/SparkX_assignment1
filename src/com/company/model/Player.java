package com.company.model;

public class Player {
    private String playerName;
    private int score;
    private String status;

    public Player( String playerName) {
        this.playerName = playerName;
        this.score = 0;
        this.status = "Available";
    }


    public String getPlayerName() {
        return playerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
