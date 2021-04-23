package com.company.model;

import com.company.conf.Configs;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    private final String teamName;
    private int currentPlayerIndex;

    public enum Status { TEAM_PLAYING, TEAM_FINISHED }
    private Status status;

    private int overCount;
    private int ballCount;


    public Team(String teamName) {
        this.teamName = teamName;
        createPlayers(teamName);
        currentPlayerIndex = 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void createPlayers(String teamName) {
        this.players = new ArrayList<>();
        for (int i = 0; i < Configs.PLAYERS_PER_TEAM; i++) {
            this.players.add(new Player( teamName + i));
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public int getScore() {
        return players.stream().mapToInt(o -> o.getScore()).sum();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getOverCount() {
        return overCount;
    }

    public void setOverCount(int overCount) {
        this.overCount = overCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
}
