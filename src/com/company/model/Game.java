package com.company.model;

import com.company.conf.Configs;

public class Game {

    private Team team1;
    private Team team2;

    private Team toss;

    private Team currentTeam;

    private String gameStatus;


    public Game(String team1, String team2) throws IllegalArgumentException {
        if (team1.equals(team2)) {
            throw new IllegalArgumentException("Team names should be unique");

        }
        this.team1 = new Team(team1);
        this.team2 = new Team(team2);
        this.gameStatus = Configs.GAME_ONGOING;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getToss() {
        return toss;
    }

    public void setToss(Team toss) {
        this.toss = toss;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

}
